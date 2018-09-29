package com.zust.lookso.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/19
 * 时 间： 16:51
 * 项 目： LookSo
 * 描 述：
 */
@Entity
public class Collect implements Serializable {
    int id;
    User user;
    Movie movie;
    String time;

    @Id
    @GeneratedValue
    @Column(name = "clct_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clct_uid")
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clct_mid")
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Column(name = "clct_time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
