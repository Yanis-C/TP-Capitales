package com.capitales.eval.db;

import jakarta.persistence.*;

@Entity
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(nullable = true)
    private Integer last_country_id;

    private Integer score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public Player() {
        this.score = 0;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLast_country_id() {
        return last_country_id;
    }

    public void setLast_country_id(Integer last_country_id) {
        this.last_country_id = last_country_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
