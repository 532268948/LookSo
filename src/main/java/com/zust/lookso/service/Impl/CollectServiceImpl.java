package com.zust.lookso.service.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.entity.Collect;
import com.zust.lookso.entity.Movie;
import com.zust.lookso.entity.User;
import com.zust.lookso.service.CollectService;
import com.zust.lookso.util.ResponseUtil;
import com.zust.lookso.util.ResponseWrapper;
import com.zust.lookso.util.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/9
 * 时 间： 12:31
 * 项 目： LookSo
 * 描 述：
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    @Qualifier("collectDao")
    CommonOperate collectDao;

    private Collect collect;
    private User user;
    private Movie movie;

    @Override
    public ResponseWrapper getUserCollect(Integer id, Integer page) {
        if (id != null && page != null) {
            if (collect == null) {
                collect = new Collect();
            }
            if (user == null) {
                user = new User();
            }
            user.setId(id);
            collect.setId(page-1);
            collect.setUser(user);
            return ResponseUtil.checkResponseMore(this.collectDao.Query(collect, 0));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper setUserCollect(Integer uid, Integer mid) {
        if (uid != null && mid != null) {
            if (collect == null) {
                collect = new Collect();
            }
            if (user == null) {
                user = new User();
            }
            if (movie == null) {
                movie = new Movie();
            }
            user.setId(uid);
            movie.setId(mid);
            collect.setUser(user);
            collect.setMovie(movie);
            DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strBeginDate = dateTimeformat.format(new Date());
            collect.setTime(strBeginDate);
            List list = this.collectDao.Add(collect);
            if (list == null) {
                return ResponseWrapper.markError();
            } else if (list.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            } else if (list.size() == 1) {
                ((Collect) list.get(0)).setTime(((Collect) list.get(0)).getTime().substring(0,
                        ((Collect) list.get(0)).getTime().length() - 2));
                return ResponseWrapper.markSuccess(list);
            }
            return ResponseWrapper.markError();
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper cancelCollect(Integer id) {
        if (id != null) {
            try {
                this.collectDao.Delete(id);
            } catch (Exception e) {
                e.printStackTrace();
                ResponseWrapper.markError();
            }
            return ResponseWrapper.markCustom(true, ReturnCode.DELETE_SUCCESS.getCode(), ReturnCode.DELETE_SUCCESS.getMsg(), null);
        }
        return ResponseWrapper.markError();
    }


}
