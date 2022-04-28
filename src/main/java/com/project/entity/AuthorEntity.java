package com.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "about")
    private String about;

    @Column(name = "email")
    private String eMail;

    public String GetEMail() {
        return eMail;
    }

    public void GetEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public AuthorEntity( String name, Long age, String about) {
        this.name = name;
        this.age = age;
        this.about = about;
    }
    public AuthorEntity(){}

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(age, that.age)) return false;
        if (!Objects.equals(about, that.about)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", about='" + about + '\'' +
                '}';
    }
}