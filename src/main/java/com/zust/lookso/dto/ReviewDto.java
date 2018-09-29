package com.zust.lookso.dto;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/9
 * 时 间： 21:31
 * 项 目： LookSo
 * 描 述：
 */
public class ReviewDto {
    long num;
    double grade;

    public ReviewDto(long num, double grade) {
        this.num = num;
        this.grade = grade;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
