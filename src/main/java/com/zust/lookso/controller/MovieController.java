package com.zust.lookso.controller;

import com.zust.lookso.service.CollectService;
import com.zust.lookso.service.MovieService;
import com.zust.lookso.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 20:56
 * 项 目： LookSo
 * 描 述：
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    CollectService collectService;

    @ResponseBody
    @RequestMapping(value = "/slider", method = RequestMethod.POST)
    public ResponseWrapper getSlider() {
        return movieService.getSlider();
    }

    @ResponseBody
    @RequestMapping(value = "/similar", method = RequestMethod.POST)
    public ResponseWrapper getSimilarMovie() {
        return movieService.getSimilarMovie();
    }

    @ResponseBody
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public ResponseWrapper getTopMovie() {
        return movieService.getTopMovie();
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseWrapper getSearchList(String message, Integer page) {
        return movieService.getSearchMovie(message, page);
    }

    @ResponseBody
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseWrapper getSortList(String sort, Integer page) {
        return movieService.getSortMovieList(sort, page);
    }

    @ResponseBody
    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public ResponseWrapper getRecommend(String sort) {
        return this.movieService.getRecommend(sort);
    }

    @ResponseBody
    @RequestMapping(value = "/collect", method = RequestMethod.POST)
    public ResponseWrapper collectMovie(Integer uid, Integer mid) {
        return this.collectService.setUserCollect(uid, mid);
    }

    @ResponseBody
    @RequestMapping(value = "/cancel_collect", method = RequestMethod.POST)
    public ResponseWrapper cancelCollect(Integer id) {
        return this.collectService.cancelCollect(id);
    }

    @ResponseBody
    @RequestMapping(value = "/iscollect", method = RequestMethod.POST)
    public ResponseWrapper isCollect(Integer uid, Integer mid) {
        return this.movieService.isCollect(uid, mid);
    }

    @ResponseBody
    @RequestMapping(value = "/information", method = RequestMethod.POST)
    public ResponseWrapper getMovieInformation(Integer id) {
        return this.movieService.getMovieInformation(id);
    }

    @ResponseBody
    @RequestMapping(value = "/ranking", method = RequestMethod.POST)
    public ResponseWrapper getRanking(Integer page) {
        return this.movieService.getAllMovieWithGrade(page);
    }

}
