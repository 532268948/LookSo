package com.zust.lookso.service;

import com.zust.lookso.util.ResponseWrapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/28
 * 时 间： 21:34
 * 项 目： LookSo
 * 描 述：
 */
public interface PersonService {
    ResponseWrapper Login(String name, String password);

    ResponseWrapper Register(String name, String password);

    ResponseWrapper getUserInformation(Integer id);

    ResponseWrapper Review(Integer score, String content, Integer uid, Integer mid);

    ResponseWrapper updateUserInformation(Integer id, String nickname, Integer sex, String desc);

    ResponseWrapper updateUserHead(HttpServletRequest request,Integer id);
}
