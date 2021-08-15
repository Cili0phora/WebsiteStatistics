package org.example.webiste.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class User {

    public User(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "birth_year")
    private int birthYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
