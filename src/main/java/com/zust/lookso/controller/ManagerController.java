package com.zust.lookso.controller;

import com.zust.lookso.entity.Movie;
import com.zust.lookso.service.ManagerService;
import com.zust.lookso.util.ResponseUtil;
import com.zust.lookso.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/10
 * 时 间： 10:41
 * 项 目： LookSo
 * 描 述：
 */
@Controller
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @ResponseBody
    @RequestMapping(value = "/all_user", method = RequestMethod.POST)
    public ResponseWrapper getAllUser() {
        return this.managerService.getAllUser();
    }

    @ResponseBody
    @RequestMapping(value = "/forbidden_user", method = RequestMethod.POST)
    public ResponseWrapper forbiddenUser(Integer id) {
        return this.managerService.forbiddenUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "/recover_user", method = RequestMethod.POST)
    public ResponseWrapper recoverUser(Integer id) {
        return this.managerService.recoverUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "/all_movie", method = RequestMethod.POST)
    public ResponseWrapper getAllMovie(Integer page) {
        return this.managerService.getAllMovie(page);
    }

    @ResponseBody
    @RequestMapping(value = "forbidden_movie", method = RequestMethod.POST)
    public ResponseWrapper forbiddenMovie(Integer id) {
        return this.managerService.forbiddenMovie(id);
    }

    @ResponseBody
    @RequestMapping(value = "/recover_movie", method = RequestMethod.POST)
    public ResponseWrapper recoverMovie(Integer id) {
        return this.managerService.recoverMovie(id);
    }

    @ResponseBody
    @RequestMapping(value = "/upload_movie")
    public ResponseWrapper uploadMovie(HttpServletRequest request, Movie movie) {
        return this.managerService.uploadNewMovie(request, movie);
    }

    @ResponseBody
    @RequestMapping(value = "/delete_review", method = RequestMethod.POST)
    public ResponseWrapper deleteReview(Integer id) {
        return this.managerService.deleteReview(id);
    }
}
