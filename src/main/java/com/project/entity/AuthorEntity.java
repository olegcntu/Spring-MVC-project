package com.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "author", schema = "public", catalog = "forum")
public class AuthorEntity {
    private long id;
    private String name;
    private Long age;
    private String about;

    public AuthorEntity( String name, Long age, String about) {
        this.name = name;
        this.age = age;
        this.about = about;
    }

    public AuthorEntity() {
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Basic
    @Column(name = "about")
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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
