package com.zust.lookso.dto;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/9
 * 时 间： 11:45
 * 项 目： LookSo
 * 描 述：
 */
public class MessageDto {
    List list;
    long num;

    public MessageDto(){}

    public MessageDto(List list, long num) {
        this.list = list;
        this.num = num;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
