package com.zust.lookso.util;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 21:11
 * 项 目： LookSo
 * 描 述：
 */
public class ResponseUtil {
    public static ResponseWrapper checkResponseOne(List list){
        if (list == null) {
            return ResponseWrapper.markError();
        } else if (list.size() == 0) {
            return ResponseWrapper.markSuccessButNoData();
        } else if (list.size() == 1) {
            return ResponseWrapper.markSuccess(list);
        }
        return ResponseWrapper.markError();
    }
    public static ResponseWrapper checkResponseMore(List list){
        if (list == null) {
            return ResponseWrapper.markError();
        } else if (list.size() == 0) {
            return ResponseWrapper.markSuccessButNoData();
        } else if (list.size() >= 1) {
            System.out.println(list.size()+"");
            return ResponseWrapper.markSuccess(list);
        }
        return ResponseWrapper.markError();
    }

    public static ResponseWrapper checkResponseObject(Object object){
        if (object==null){
            return ResponseWrapper.markError();
        }else {
            return ResponseWrapper.markSuccess(object);
        }
    }
}
