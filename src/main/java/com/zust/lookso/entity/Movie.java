package com.zust.lookso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/19
 * 时 间： 16:45
 * 项 目： LookSo
 * 描 述：影片实体
 */
@Entity
public class Movie {
    int id;
    String name;
    String cover;
    String slider;
    Date show;
    int time;
    String sort;
    String ctry;
    String dir;

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
    public Date getShow() {
        return show;
    }

    public void setShow(Date show) {
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

    @Column(name = "movie_crty")
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
}
