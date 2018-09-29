package com.zust.lookso.service;

import com.zust.lookso.entity.Movie;
import com.zust.lookso.util.ResponseWrapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/10
 * 时 间： 11:11
 * 项 目： LookSo
 * 描 述：
 */
public interface ManagerService {
    ResponseWrapper getAllUser();

    ResponseWrapper forbiddenUser(Integer id);

    ResponseWrapper recoverUser(Integer id);

    ResponseWrapper getAllMovie(Integer page);

    ResponseWrapper forbiddenMovie(Integer id);

    ResponseWrapper recoverMovie(Integer id);

    ResponseWrapper uploadNewMovie(HttpServletRequest request, Movie movie);

    ResponseWrapper deleteReview(Integer id);
}
