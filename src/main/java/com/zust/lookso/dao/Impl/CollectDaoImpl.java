package com.zust.lookso.dao.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.entity.Collect;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/9
 * 时 间： 12:21
 * 项 目： LookSo
 * 描 述：
 */
@Repository
@Qualifier("collectDao")
public class CollectDaoImpl implements CommonOperate {

    @Autowired
    SessionFactory sessionFactory;

    private Collect collect;

    @Override
    public List Add(Object data) {
        if (data != null) {
            collect = (Collect) data;
            int id = (Integer) this.sessionFactory.openSession().save(collect);
            return this.sessionFactory.openSession().createQuery("from Collect collect where collect.id='" + id + "'").list();
        }
        return null;
    }

    @Override
    public void Delete(int id) {
        sessionFactory.openSession().createQuery("delete from Collect collect where collect.id='" + id + "'").executeUpdate();
    }

    @Override
    public void Revise(Object data, int i) {

    }

    /**
     * @param data
     * @param i    0获取用户收藏 1是否收藏
     * @return
     */
    @Override
    public List Query(Object data, int i) {
        if (data != null) {
            collect = (Collect) data;
        }
        if (i == 0) {
            return this.sessionFactory.openSession().createQuery("from Collect collect where collect.user" +
                    "='" + collect.getUser().getId() + "'")
                    .setFirstResult(10 * collect.getId())
                    .setMaxResults(10)
                    .list();
        }
        if (i == 1) {
            return this.sessionFactory.openSession().createQuery("from Collect collect where collect.user=" +
                    "'" + collect.getUser().getId() + "' and collect.movie='" + collect.getMovie().getId() + "'")
                    .list();
        }
        return null;
    }
}
