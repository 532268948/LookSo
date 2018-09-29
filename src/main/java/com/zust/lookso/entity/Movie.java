package com.zust.lookso.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/19
 * 时 间： 16:45
 * 项 目： LookSo
 * 描 述：影片实体
 */
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    int id;
    String name;
    String cover;
    String slider;
    String show;
    int time;
    String sort;
    String ctry;
    String dir;
    String act;
    String intro;
    int status;

    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "movie_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "movie_cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "movie_slider")
    public String getSlider() {
        return slider;
    }

    public void setSlider(String slider) {
        this.slider = slider;
    }

    @Column(name = "movie_show")
    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    @Column(name = "movie_time")
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Column(name = "movie_sort")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Column(name = "movie_ctry")
    public String getCtry() {
        return ctry;
    }

    public void setCtry(String ctry) {
        this.ctry = ctry;
    }

    @Column(name = "movie_dir")
    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Column(name = "movie_act")
    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    @Column(name = "movie_intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Column(name = "movie_status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
