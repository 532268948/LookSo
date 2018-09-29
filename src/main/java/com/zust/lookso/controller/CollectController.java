package com.zust.lookso.controller;

import com.zust.lookso.service.CollectService;
import com.zust.lookso.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/9
 * 时 间： 13:28
 * 项 目： LookSo
 * 描 述：
 */
@Controller
@RequestMapping("collect")
public class CollectController {

    @Autowired
    CollectService collectService;

    @ResponseBody
    @RequestMapping(value = "/user_collect",method = RequestMethod.POST)
    public ResponseWrapper getUserCollect(Integer id,Integer page){
        return this.collectService.getUserCollect(id,page);
    }

}
