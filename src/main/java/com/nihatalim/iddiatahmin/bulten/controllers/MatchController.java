package com.nihatalim.iddiatahmin.bulten.controllers;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "matches")
public class MatchController {

    Session session = null;
    Criteria criteria = null;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Match> allMathes() {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.criteria = this.session.createCriteria(Match.class);
        List<Match> matches = this.criteria.list();
        this.session.close();
        return matches;
    }

    @RequestMapping(value = "/type/{tip}", method = RequestMethod.GET)
    public List<Match> getFootballMatches(@PathVariable String tip) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.criteria = this.session.createCriteria(Match.class);
        this.criteria.add(Restrictions.eq("sinif", tip));
        List<Match> matches = this.criteria.list();
        this.session.close();
        return matches;
    }

    @RequestMapping(value = "/get/{code}", method = RequestMethod.GET)
    public Match get(@PathVariable int code) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.criteria = this.session.createCriteria(Match.class);
        this.criteria.add(Restrictions.eq("matchID", code));
        List<Match> matches = this.criteria.list();
        Match match = null;
        if(matches.size()>0){
            match = matches.get(0);
        }

        this.session.close();
        return match;
    }


}
