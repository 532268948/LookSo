package com.zust.lookso.controller;

import com.zust.lookso.service.ReviewService;
import com.zust.lookso.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/4
 * 时 间： 20:58
 * 项 目： LookSo
 * 描 述：
 */
@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResponseWrapper getReviewList(Integer id) {
        return this.reviewService.getReviewList(id);
    }

    @ResponseBody
    @RequestMapping(value = "/comment_num", method = RequestMethod.POST)
    public ResponseWrapper getReviewNum(Integer id) {
        return this.reviewService.getReviewNum(id);
    }

    @ResponseBody
    @RequestMapping(value = "/user_comment", method = RequestMethod.POST)
    public ResponseWrapper getUserReview(Integer id, Integer page) {
        return this.reviewService.getUserReviewList(id, page);
    }

    @ResponseBody
    @RequestMapping(value = "/hot_comment", method = RequestMethod.POST)
    public ResponseWrapper getHotReviewList() {
        return this.reviewService.getHotReviewList();
    }

    @ResponseBody
    @RequestMapping(value = "hot_review", method = RequestMethod.POST)
    public ResponseWrapper getHotReview(Integer page,Integer type) {
        return this.reviewService.getHotReview(page,type);
    }
}
