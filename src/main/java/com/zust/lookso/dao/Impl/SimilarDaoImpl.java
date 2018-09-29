package com.zust.lookso.dao.Impl;

import com.zust.lookso.dao.SimilarDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 22:41
 * 项 目： LookSo
 * 描 述：
 */
@Repository
@Qualifier("similarDao")
public class SimilarDaoImpl implements SimilarDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List getSimilar() {
        return this.sessionFactory.openSession().createQuery("from Movie movie where movie.status='0'").list();
    }
}
