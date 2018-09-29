package com.zust.lookso.service;

import com.zust.lookso.entity.Movie;
import com.zust.lookso.util.ResponseWrapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 20:58
 * 项 目： LookSo
 * 描 述：
 */
public interface MovieService {
    ResponseWrapper getSlider();
    ResponseWrapper getSimilarMovie();
    ResponseWrapper getTopMovie();
    ResponseWrapper getSearchMovie(String message, Integer page);
    ResponseWrapper getSortMovieList(String sort,Integer page);
    ResponseWrapper getMovieInformation(Integer id);
    ResponseWrapper isCollect(Integer uid,Integer mid);
    ResponseWrapper getRecommend(String sort);
    ResponseWrapper getAllMovieWithGrade(Integer page);
}
