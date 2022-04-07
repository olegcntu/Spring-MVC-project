package com.project.models;

import java.util.Date;

public class Article {
    private int id;
    private String name;
    private String topic;
    private Author author;
    private int grade;
    private Date date;
    private String txt;

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

    public Date getDate() {
        return date;
    }

    public String getTxt() {
        return txt;
    }

    public int getId() {
        return id;
    }

    public Article(int id, String name, String topic, Author author, int grade, Date date) {
        this.id=id;
        this.name = name;
        this.topic = topic;
        this.author = author;
        this.grade = grade;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", author=" + author +
                ", grade=" + grade +
                ", date=" + date +
                '}'+"/n";
    }
}
