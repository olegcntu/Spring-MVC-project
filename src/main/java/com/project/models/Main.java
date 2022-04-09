package com.project.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Article article = new Article();
        //article.date=new Date();
        //System.out.println(article.date);
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd  hh:mm");

        System.out.println(formatForDateNow.format(dateNow));
    }
}
