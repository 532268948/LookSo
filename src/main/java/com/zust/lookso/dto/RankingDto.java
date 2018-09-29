package com.zust.lookso.dto;

import com.zust.lookso.entity.Movie;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/16
 * 时 间： 15:22
 * 项 目： LookSo
 * 描 述：
 */
public class RankingDto {
    int id;
    String name;
    String cover;
    String show;
    String dir;
    String act;
    double grade;

    public RankingDto(int id, String name, String cover, String show, String dir, String act, double grade) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.show = show;
        this.dir = dir;
        this.act = act;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
