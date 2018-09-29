package com.zust.lookso.dto;

import com.zust.lookso.entity.Movie;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/9
 * 时 间： 10:22
 * 项 目： LookSo
 * 描 述：
 */
public class MovieDto {
    Movie movie;
    float grade;

    public MovieDto(Movie movie, float grade) {
        this.movie = movie;
        this.grade = grade;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
