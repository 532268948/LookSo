package com.zust.lookso.controller;

import com.zust.lookso.service.PersonService;
import com.zust.lookso.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/12
 * 时 间： 21:52
 * 项 目： LookSo
 * 描 述：
 */

@Controller
@RequestMapping("user")
public class PersonController {

    @Autowired
    PersonService personService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseWrapper Login(String name, String password) {
        return personService.Login(name, password);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseWrapper Register(String name, String password) {
        return personService.Register(name, password);
    }

    @ResponseBody
    @RequestMapping(value = "/information", method = RequestMethod.POST)
    public ResponseWrapper addUserInformation(Integer id) {
        return personService.getUserInformation(id);
    }

    @ResponseBody
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ResponseWrapper Review(Integer score, String content, Integer uid, Integer mid) {
        return this.personService.Review(score, content, uid, mid);
    }

    @ResponseBody
    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public ResponseWrapper Review(Integer id, String nickname, Integer sex, String desc) {
        return this.personService.updateUserInformation(id, nickname, sex, desc);
    }

    @ResponseBody
    @RequestMapping(value = "/update_head",method = RequestMethod.POST)
    public ResponseWrapper updateHead( HttpServletRequest request, Integer id){
        return this.personService.updateUserHead(request ,id);
    }
}
