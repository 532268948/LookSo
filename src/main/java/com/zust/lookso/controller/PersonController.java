package com.zust.lookso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/12
 * 时 间： 21:52
 * 项 目： LookSo
 * 描 述：
 */

@Controller
@RequestMapping("person")
public class PersonController {

//    @ResponseBody
    @RequestMapping("/index")
    public String test(){
        return "测试成功";
    }

}
