package com.zust.lookso.service;

import com.zust.lookso.util.ResponseWrapper;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/9
 * 时 间： 12:31
 * 项 目： LookSo
 * 描 述：
 */
public interface CollectService {
    ResponseWrapper getUserCollect(Integer id,Integer page);
    ResponseWrapper setUserCollect(Integer uid,Integer mid);
    ResponseWrapper cancelCollect(Integer id);
}
