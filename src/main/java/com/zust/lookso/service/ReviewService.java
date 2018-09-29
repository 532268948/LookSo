package com.zust.lookso.service;

import com.zust.lookso.entity.Review;
import com.zust.lookso.util.ResponseWrapper;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/4
 * 时 间： 21:08
 * 项 目： LookSo
 * 描 述：
 */
public interface ReviewService {
    ResponseWrapper getReviewList(Integer id);
    ResponseWrapper getReviewNum(Integer id);
    ResponseWrapper getUserReviewList(Integer id,Integer page);
    ResponseWrapper getHotReviewList();
    ResponseWrapper getHotReview(Integer page,Integer type);
}
