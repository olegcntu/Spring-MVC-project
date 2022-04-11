package com.project.models;

import com.project.dao.ArticleDAO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Article {
    private int id;
    private String name;
    private String topic;
    private Author author;
    private int grade;
    private Date date;
    private String txt;

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public String getAuthor() {
        return author.getName();
    }

    public int getGrade() {
        return grade;
    }


    public String getDate() {

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd  hh:mm");
        return formatForDateNow.format(date);
    }

    public String getTxt() {
        return txt;
    }

    public int getId() {
        return id;
    }

    public Article(){};

    public Article(String name, String topic, String txt) {
        this.id = ++ArticleDAO.ARTICLE_ID;
        this.name = name;
        this.topic = topic;
        this.date = new Date();
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", author=" + author +
                ", grade=" + grade +
                ", date=" + date +
                '}' + "/n";
    }
}
