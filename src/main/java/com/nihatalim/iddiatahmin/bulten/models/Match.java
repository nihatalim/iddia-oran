package com.nihatalim.iddiatahmin.bulten.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bulten_veri")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = "bltn_tarih")
    private Date date;

    @Column(name = "bltn_macid")
    private int matchID;

    @Column(name = "bltn_lig")
    private String league;

    @Temporal(TemporalType.TIME)
    @Column(name = "bltn_saat")
    private Date time;

    @Column(name = "bltn_mbs")
    private double mbs;

    @Column(name = "bltn_handikapiyev")
    private double handikapiyev;

    @Column(name = "bltn_handikapmsev")
    private double handikapmsev;

    @Column(name = "bltn_ev")
    private String ev;

    @Column(name = "bltn_macsonucu1")
    private double macsonucu1;

    @Column(name = "bltn_macsonucu0")
    private double macsonucu0;

    @Column(name = "bltn_macsonucu2")
    private double macsonucu2;

    @Column(name = "bltn_konuk")
    private String konuk;

    @Column(name = "bltn_handikapiykonuk")
    private double handikapiykonuk;

    @Column(name = "bltn_handikapmskonuk")
    private double handikapmskonuk;

    @Column(name = "bltn_ciftsans10")
    private double ciftsans10;

    @Column(name = "bltn_ciftsans12")
    private double ciftsans12;

    @Column(name = "bltn_ciftcans20")
    private double ciftcans20;

    @Column(name = "bltn_handikap1")
    private double handikap1;

    @Column(name = "bltn_handikap0")
    private double handikap0;

    @Column(name = "bltn_handikap2")
    private double handikap2;

    @Column(name = "bltn_gol15alt")
    private double gol15alt;

    @Column(name = "bltn_gol15ust")
    private double gol15ust;

    @Column(name = "bltn_gol25alt")
    private double gol25alt;

    @Column(name = "bltn_gol25ust")
    private double gol25ust;

    @Column(name = "bltn_gol35alt")
    private double gol35alt;

    @Column(name = "bltn_gol35ust")
    private double gol35ust;

    @Column(name = "bltn_toplamsayi")
    private double toplamsayi;

    @Column(name = "bltn_kgvar")
    private double kgvar;

    @Column(name = "bltn_kgyok")
    private double kgyok;

    @Column(name = "bltn_toplamgol01")
    private double toplamgol01;

    @Column(name = "bltn_toplamgol23")
    private double toplamgol23;

    @Column(name = "bltn_toplamgol46")
    private double toplamgol46;

    @Column(name = "bltn_toplamgol7")
    private double toplamgol7;

    @Column(name = "bltn_ilkyarisonucu1")
    private double ilkyarisonucu1;

    @Column(name = "bltn_ilkyarisonucu0")
    private double ilkyarisonucu0;

    @Column(name = "bltn_ilkyarisonucu2")
    private double ilkyarisonucu2;

    @Column(name = "bltn_ilkyarisonucu15ust")
    private double ilkyarisonucu15ust;

    @Column(name = "bltn_ilkyarisonucu15alt")
    private double ilkyarisonucu15alt;

    @Column(name = "bltn_iymac11")
    private double iymac11;

    @Column(name = "bltn_iymac01")
    private double iymac01;

    @Column(name = "bltn_iymac21")
    private double iymac21;

    @Column(name = "bltn_iymac10")
    private double iymac10;

    @Column(name = "bltn_iymac00")
    private double iymac00;

    @Column(name = "bltn_iymac20")
    private double iymac20;

    @Column(name = "bltn_iymac12")
    private double iymac12;

    @Column(name = "bltn_iymac02")
    private double iymac02;

    @Column(name = "bltn_iymac22")
    private double iymac22;

    @Column(name = "bltn_benzersiz",unique = true)
    private String benzersiz;

    @Column(name = "bltn_sinif")
    private String sinif;


    public Match() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getMbs() {
        return mbs;
    }

    public void setMbs(double mbs) {
        this.mbs = mbs;
    }

    public double getHandikapiyev() {
        return handikapiyev;
    }

    public void setHandikapiyev(double handikapiyev) {
        this.handikapiyev = handikapiyev;
    }

    public double getHandikapmsev() {
        return handikapmsev;
    }

    public void setHandikapmsev(double handikapmsev) {
        this.handikapmsev = handikapmsev;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    public double getMacsonucu1() {
        return macsonucu1;
    }

    public void setMacsonucu1(double macsonucu1) {
        this.macsonucu1 = macsonucu1;
    }

    public double getMacsonucu0() {
        return macsonucu0;
    }

    public void setMacsonucu0(double macsonucu0) {
        this.macsonucu0 = macsonucu0;
    }

    public double getMacsonucu2() {
        return macsonucu2;
    }

    public void setMacsonucu2(double macsonucu2) {
        this.macsonucu2 = macsonucu2;
    }

    public String getKonuk() {
        return konuk;
    }

    public void setKonuk(String konuk) {
        this.konuk = konuk;
    }

    public double getHandikapiykonuk() {
        return handikapiykonuk;
    }

    public void setHandikapiykonuk(double handikapiykonuk) {
        this.handikapiykonuk = handikapiykonuk;
    }

    public double getHandikapmskonuk() {
        return handikapmskonuk;
    }

    public void setHandikapmskonuk(double handikapmskonuk) {
        this.handikapmskonuk = handikapmskonuk;
    }

    public double getCiftsans10() {
        return ciftsans10;
    }

    public void setCiftsans10(double ciftsans10) {
        this.ciftsans10 = ciftsans10;
    }

    public double getCiftsans12() {
        return ciftsans12;
    }

    public void setCiftsans12(double ciftsans12) {
        this.ciftsans12 = ciftsans12;
    }

    public double getCiftcans20() {
        return ciftcans20;
    }

    public void setCiftcans20(double ciftcans20) {
        this.ciftcans20 = ciftcans20;
    }

    public double getHandikap1() {
        return handikap1;
    }

    public void setHandikap1(double handikap1) {
        this.handikap1 = handikap1;
    }

    public double getHandikap0() {
        return handikap0;
    }

    public void setHandikap0(double handikap0) {
        this.handikap0 = handikap0;
    }

    public double getHandikap2() {
        return handikap2;
    }

    public void setHandikap2(double handikap2) {
        this.handikap2 = handikap2;
    }

    public double getGol15alt() {
        return gol15alt;
    }

    public void setGol15alt(double gol15alt) {
        this.gol15alt = gol15alt;
    }

    public double getGol15ust() {
        return gol15ust;
    }

    public void setGol15ust(double gol15ust) {
        this.gol15ust = gol15ust;
    }

    public double getGol25alt() {
        return gol25alt;
    }

    public void setGol25alt(double gol25alt) {
        this.gol25alt = gol25alt;
    }

    public double getGol25ust() {
        return gol25ust;
    }

    public void setGol25ust(double gol25ust) {
        this.gol25ust = gol25ust;
    }

    public double getGol35alt() {
        return gol35alt;
    }

    public void setGol35alt(double gol35alt) {
        this.gol35alt = gol35alt;
    }

    public double getGol35ust() {
        return gol35ust;
    }

    public void setGol35ust(double gol35ust) {
        this.gol35ust = gol35ust;
    }

    public double getToplamsayi() {
        return toplamsayi;
    }

    public void setToplamsayi(double toplamsayi) {
        this.toplamsayi = toplamsayi;
    }

    public double getKgvar() {
        return kgvar;
    }

    public void setKgvar(double kgvar) {
        this.kgvar = kgvar;
    }

    public double getKgyok() {
        return kgyok;
    }

    public void setKgyok(double kgyok) {
        this.kgyok = kgyok;
    }

    public double getToplamgol01() {
        return toplamgol01;
    }

    public void setToplamgol01(double toplamgol01) {
        this.toplamgol01 = toplamgol01;
    }

    public double getToplamgol23() {
        return toplamgol23;
    }

    public void setToplamgol23(double toplamgol23) {
        this.toplamgol23 = toplamgol23;
    }

    public double getToplamgol46() {
        return toplamgol46;
    }

    public void setToplamgol46(double toplamgol46) {
        this.toplamgol46 = toplamgol46;
    }

    public double getToplamgol7() {
        return toplamgol7;
    }

    public void setToplamgol7(double toplamgol7) {
        this.toplamgol7 = toplamgol7;
    }

    public double getIlkyarisonucu1() {
        return ilkyarisonucu1;
    }

    public void setIlkyarisonucu1(double ilkyarisonucu1) {
        this.ilkyarisonucu1 = ilkyarisonucu1;
    }

    public double getIlkyarisonucu0() {
        return ilkyarisonucu0;
    }

    public void setIlkyarisonucu0(double ilkyarisonucu0) {
        this.ilkyarisonucu0 = ilkyarisonucu0;
    }

    public double getIlkyarisonucu2() {
        return ilkyarisonucu2;
    }

    public void setIlkyarisonucu2(double ilkyarisonucu2) {
        this.ilkyarisonucu2 = ilkyarisonucu2;
    }

    public double getIlkyarisonucu15ust() {
        return ilkyarisonucu15ust;
    }

    public void setIlkyarisonucu15ust(double ilkyarisonucu15ust) {
        this.ilkyarisonucu15ust = ilkyarisonucu15ust;
    }

    public double getIlkyarisonucu15alt() {
        return ilkyarisonucu15alt;
    }

    public void setIlkyarisonucu15alt(double ilkyarisonucu15alt) {
        this.ilkyarisonucu15alt = ilkyarisonucu15alt;
    }

    public double getIymac11() {
        return iymac11;
    }

    public void setIymac11(double iymac11) {
        this.iymac11 = iymac11;
    }

    public double getIymac01() {
        return iymac01;
    }

    public void setIymac01(double iymac01) {
        this.iymac01 = iymac01;
    }

    public double getIymac21() {
        return iymac21;
    }

    public void setIymac21(double iymac21) {
        this.iymac21 = iymac21;
    }

    public double getIymac10() {
        return iymac10;
    }

    public void setIymac10(double iymac10) {
        this.iymac10 = iymac10;
    }

    public double getIymac00() {
        return iymac00;
    }

    public void setIymac00(double iymac00) {
        this.iymac00 = iymac00;
    }

    public double getIymac20() {
        return iymac20;
    }

    public void setIymac20(double iymac20) {
        this.iymac20 = iymac20;
    }

    public double getIymac12() {
        return iymac12;
    }

    public void setIymac12(double iymac12) {
        this.iymac12 = iymac12;
    }

    public double getIymac02() {
        return iymac02;
    }

    public void setIymac02(double iymac02) {
        this.iymac02 = iymac02;
    }

    public double getIymac22() {
        return iymac22;
    }

    public void setIymac22(double iymac22) {
        this.iymac22 = iymac22;
    }

    public String getBenzersiz() {
        return benzersiz;
    }

    public void setBenzersiz(String benzersiz) {
        this.benzersiz = benzersiz;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }
}
