package com.zust.lookso.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/19
 * 时 间： 18:40
 * 项 目： LookSo
 * 描 述：
 */

@Entity
public class Review implements Serializable {
    int id;
    User user;
    Movie movie;
    String content;
    int score;
    String time;

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_uid")
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_mid")
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Column(name = "review_cont")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "review_score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name = "review_time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
