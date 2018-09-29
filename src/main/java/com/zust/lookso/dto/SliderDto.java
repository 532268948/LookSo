package com.zust.lookso.dto;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 21:00
 * 项 目： LookSo
 * 描 述：
 */
public class SliderDto {

    private Integer movieId;
    private String movieSlider;
    private String movieName;

    public SliderDto(Integer movieId, String movieSlider, String movieName) {
        this.movieId = movieId;
        this.movieSlider = movieSlider;
        this.movieName = movieName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieSlider() {
        return movieSlider;
    }

    public void setMovieCover(String movieSlider) {
        this.movieSlider = movieSlider;
    }

    public void setMovieSlider(String movieSlider) {
        this.movieSlider = movieSlider;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
