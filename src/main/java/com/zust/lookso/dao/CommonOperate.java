package com.zust.lookso.dao;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/28
 * 时 间： 21:41
 * 项 目： LookSo
 * 描 述：
 */
public interface CommonOperate {
    List Add(Object data);
    void Delete(int id);
    void Revise(Object data,int i);
    List Query(Object data,int i);
}
