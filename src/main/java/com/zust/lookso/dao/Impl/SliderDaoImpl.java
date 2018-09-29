package com.zust.lookso.dao.Impl;

import com.zust.lookso.dao.SliderDao;
import com.zust.lookso.dao.TopDao;
import com.zust.lookso.entity.Movie;
import com.zust.lookso.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 21:02
 * 项 目： LookSo
 * 描 述：
 */
@Repository
@Qualifier("sliderDao")
public class SliderDaoImpl implements SliderDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List getSlider() {
        return this.sessionFactory.openSession().createQuery("from Movie")
                .setMaxResults(5)
                .list();
    }

}
