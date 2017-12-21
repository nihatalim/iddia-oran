package com.nihatalim.iddiatahmin.bulten.schedulers;

import com.nihatalim.iddiatahmin.bulten.models.Match;
import com.nihatalim.iddiatahmin.bulten.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MatchScheduler {
    Session session = null;
    Criteria criteria = null;

    private String url = "https://www.iddaa.com/iddaa-programi-pdf-indir/";
    private String cdnUrl = null;

    private List<Match> matches = null;
    private Match match = null;
    private SimpleDateFormat format = new SimpleDateFormat();

    @Scheduled(fixedRate = 3600000, initialDelay = 3000)
    public void scheduledFunction() {
        this.matches = new ArrayList<>();
        this.updateLastFixture();
        this.getAllMatches(); // MAÇ LİSTESİNİ DOLDURUR

        this.session = HibernateUtil.getSessionFactory().openSession();

        for (Match match : this.matches) {
            try {
                this.session.beginTransaction();
                this.criteria = this.session.createCriteria(Match.class);
                this.criteria.add(Restrictions.eq("benzersiz", match.getBenzersiz()));
                List<Match> criterlist = this.criteria.list();
                if(criterlist.size()>0){
                    match.setID(criterlist.get(0).getID());
                    this.session.update(match);
                }else{
                    this.session.save(match);
                }
                this.session.getTransaction().commit();
            } catch (Exception ex) {
                this.session.getTransaction().rollback();
            }
        }
        this.session.close();
        System.out.println("Scheduled function handled count of match:" + this.matches.size());
    }

    private String updateLastFixture() {
        String date = null;
        try {
            Document doc = Jsoup.connect(this.url).get();
            Elements fixtureElements = doc.getElementsByClass("news-item clearfix");
            String href = fixtureElements.get(0).getElementsByTag("a").attr("href");
            String splittedText = href.split("/")[2];
            String[] splittedTire = splittedText.split("-");
            date = splittedTire[0] + "-" +
                    splittedTire[1] + "." +
                    this.getMonthIndex(splittedTire[2]) + "." +
                    splittedTire[3];
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.cdnUrl = "http://cdn.iddaa.com/iddaa/bulten/next/" + date + ".html";
            return date;
        }
    }

    private void getAllMatches() {
        try {
            Document doc = Jsoup.connect(this.cdnUrl).get();
            Elements tables = doc.getElementsByTag("table");
            for (Element table : tables) {
                String tarih = table.childNodes().get(1).childNodes().get(1).childNodes().get(1).childNodes().get(0).outerHtml();
                Date date = this.parseDate(tarih);
                Elements matchElements = table.getElementsByTag("tbody").get(0).getElementsByTag("tr");
                for (Element matchElement : matchElements) {
                    Elements matchProperties = matchElement.getElementsByTag("td");
                    this.match = new Match();
                    try {
                        this.match.setDate(date);
                        this.match.setSinif(matchProperties.get(0).html());
                        this.match.setLeague(matchProperties.get(1).html());

                        this.format.applyPattern("HH:mm");
                        Date parsedDate = this.format.parse(matchProperties.get(2).html());
                        this.match.setTime(new Date(date.getYear(), date.getMonth(), date.getDate(), parsedDate.getHours(), parsedDate.getMinutes()));
                        this.match.setMatchID(Integer.parseInt(matchProperties.get(3).html()));

                        this.match.setMbs(this.doubleParser(matchProperties.get(4).html()));
                        this.match.setHandikapiyev(this.doubleParser(matchProperties.get(5).html()));
                        this.match.setHandikapmsev(this.doubleParser(matchProperties.get(6).html()));
                        this.match.setEv(matchProperties.get(7).getElementsByTag("p").get(0).html());

                        //MAÇ SONUCU SET
                        this.match.setMacsonucu1(this.doubleParser(matchProperties.get(8).html()));
                        this.match.setMacsonucu0(this.doubleParser(matchProperties.get(9).html()));
                        this.match.setMacsonucu2(this.doubleParser(matchProperties.get(10).html()));

                        this.match.setKonuk(matchProperties.get(11).getElementsByTag("p").get(0).html());
                        this.match.setHandikapiykonuk(this.doubleParser(matchProperties.get(12).html()));
                        this.match.setHandikapmskonuk(this.doubleParser(matchProperties.get(13).html()));

                        //ÇİFTE ŞANS SET
                        this.match.setCiftsans10(this.doubleParser(matchProperties.get(14).html()));
                        this.match.setCiftsans12(this.doubleParser(matchProperties.get(15).html()));
                        this.match.setCiftcans20(this.doubleParser(matchProperties.get(16).html()));

                        //HANDİKAP SET
                        this.match.setHandikap1(this.doubleParser(matchProperties.get(17).html()));
                        this.match.setHandikap0(this.doubleParser(matchProperties.get(18).html()));
                        this.match.setHandikap2(this.doubleParser(matchProperties.get(19).html()));

                        //GOL SET
                        this.match.setGol15alt(this.doubleParser(matchProperties.get(20).html()));
                        this.match.setGol15ust(this.doubleParser(matchProperties.get(21).html()));
                        this.match.setGol25alt(this.doubleParser(matchProperties.get(22).html()));
                        this.match.setGol25ust(this.doubleParser(matchProperties.get(23).html()));
                        this.match.setGol35alt(this.doubleParser(matchProperties.get(24).html()));
                        this.match.setGol35ust(this.doubleParser(matchProperties.get(25).html()));

                        this.match.setToplamsayi(this.doubleParser(matchProperties.get(26).html()));

                        //KARŞILIKLI
                        this.match.setKgvar(this.doubleParser(matchProperties.get(27).html()));
                        this.match.setKgyok(this.doubleParser(matchProperties.get(28).html()));

                        //TOPLAM GOL
                        this.match.setToplamgol01(this.doubleParser(matchProperties.get(29).html()));
                        this.match.setToplamgol23(this.doubleParser(matchProperties.get(30).html()));
                        this.match.setToplamgol46(this.doubleParser(matchProperties.get(31).html()));
                        this.match.setToplamgol7(this.doubleParser(matchProperties.get(32).html()));

                        // İLK YARI SONUCU
                        this.match.setIlkyarisonucu1(this.doubleParser(matchProperties.get(33).html()));
                        this.match.setIlkyarisonucu0(this.doubleParser(matchProperties.get(34).html()));
                        this.match.setIlkyarisonucu2(this.doubleParser(matchProperties.get(35).html()));

                        //Gol15 İlk yarı
                        this.match.setIlkyarisonucu15alt(this.doubleParser(matchProperties.get(36).html()));
                        this.match.setIlkyarisonucu15ust(this.doubleParser(matchProperties.get(37).html()));

                        //IY maç sonucu
                        this.match.setIymac11(this.doubleParser(matchProperties.get(38).html()));
                        this.match.setIymac01(this.doubleParser(matchProperties.get(39).html()));
                        this.match.setIymac21(this.doubleParser(matchProperties.get(40).html()));
                        this.match.setIymac10(this.doubleParser(matchProperties.get(41).html()));
                        this.match.setIymac00(this.doubleParser(matchProperties.get(42).html()));
                        this.match.setIymac20(this.doubleParser(matchProperties.get(43).html()));
                        this.match.setIymac12(this.doubleParser(matchProperties.get(44).html()));
                        this.match.setIymac20(this.doubleParser(matchProperties.get(45).html()));
                        this.match.setIymac22(this.doubleParser(matchProperties.get(46).html()));
                        this.format.applyPattern("yyyyMMdd");

                        this.match.setBenzersiz(this.format.format(this.match.getDate()) + this.match.getMatchID());

                        this.matches.add(this.match);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getMonthIndex(String month) {
        switch (month) {
            case "ocak":
                return "01";
            case "subat":
                return "02";
            case "mart":
                return "03";
            case "nisan":
                return "04";
            case "mayis":
                return "05";
            case "haziran":
                return "06";
            case "temmuz":
                return "07";
            case "agustos":
                return "08";
            case "eylul":
                return "09";
            case "ekim":
                return "10";
            case "kasim":
                return "11";
            case "aralik":
                return "12";
            case "Ocak":
                return "01";
            case "Şubat":
                return "02";
            case "Mart":
                return "03";
            case "Nisan":
                return "04";
            case "Mayıs":
                return "05";
            case "Haziran":
                return "06";
            case "Temmuz":
                return "07";
            case "Ağustos":
                return "08";
            case "Eylül":
                return "09";
            case "Ekim":
                return "10";
            case "Kasım":
                return "11";
            case "Aralık":
                return "12";

        }
        return null;
    }

    private Date parseDate(String tarih) {
        Date date = null;
        this.format.applyPattern("dd-MM-yyyy");
        try {
            String[] splittedTarih = tarih.split(" ");
            tarih = splittedTarih[1] + "-" + this.getMonthIndex(splittedTarih[2]) + "-" + splittedTarih[3];
            date = this.format.parse(tarih);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }

    private double doubleParser(String data) {
        double parsed = 0;
        try {
            data = data.replace(",", ".");
            parsed = Double.parseDouble(data);
        } catch (Exception ex) {
            parsed = 0;
        }
        return parsed;
    }
}
