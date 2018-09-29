package com.zust.lookso.dao.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.entity.Review;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/4
 * 时 间： 20:59
 * 项 目： LookSo
 * 描 述：
 */
@Repository
@Qualifier("reviewDao")
public class ReviewDaoImpl implements CommonOperate {

    @Autowired
    SessionFactory sessionFactory;

    private Review review;

    @Override
    public List Add(Object data) {
        return null;
    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public void Revise(Object data, int i) {

    }

    /**
     * @param data
     * @param i    0获取电影评论 2获取电影评论数 3获取用户评论 4首页推荐评论 5热门评论 6获取电影总数 7获取电影(时间排序)
     *             8所有电影平均分 9添加用户评论 10删除影评
     * @return
     */
    @Override
    public List Query(Object data, int i) {
        if (data != null) {
            review = (Review) data;
        }
        if (i == 0) {
            return this.sessionFactory.openSession().createQuery("select new com.zust.lookso.dto.CommentDto(review.id," +
                    "review.user.id,review.user.head,review.user.level,review.user.nickname,review.content,review.score,review.time) from Review review " +
                    "where review.movie='" + review.getMovie().getId() + "' order by review.user.level desc").list();
        }
        if (i == 1) {
            return this.sessionFactory.openSession().createQuery("from Review review where review.movie" +
                    "='" + review.getMovie().getId() + "'").list();
        }
        if (i == 2) {
            try {
                return this.sessionFactory.openSession().createQuery("select new com.zust.lookso.dto.ReviewDto(count(*),avg(score)) from Review review where review.movie='" + review.getId() + "'").list();
            } catch (Exception e) {
                return new ArrayList();
            }
        }
        if (i == 3) {
            return this.sessionFactory.openSession().createQuery("from Review review where review.user='" + review.getUser().getId() + "'").list();
        }
        if (i == 4) {
            return this.sessionFactory.openSession().createQuery("from Review review").setMaxResults(6).list();
        }
        if (i == 5) {
            return this.sessionFactory.openSession().createQuery("from Review review order by review.user.level desc" +
                    "")
                    .setFirstResult(10 * review.getId())
                    .setMaxResults(10)
                    .list();
        }
        if (i == 6) {
            return this.sessionFactory.openSession().createQuery("select count(*) from Review").list();
        }
        if (i == 7) {
            return this.sessionFactory.openSession().createQuery("from Review review order by review.time desc")
                    .setFirstResult(10 * review.getId())
                    .setMaxResults(10)
                    .list();
        }
        if (i == 8) {
            return this.sessionFactory.openSession().createQuery("select new com.zust.lookso.dto.RankingDto(review.movie.id," +
                    "review.movie.name, review.movie.cover,review.movie.show,review.movie.dir,review.movie.act,avg(review.score)) " +
                    "from Review review group by review.movie order by avg(review.score) desc").list();
        }
        if (i == 9) {
            Integer id = (Integer) this.sessionFactory.openSession().save(review);
            return this.sessionFactory.openSession().createQuery("from Review review where review.id='" + id + "'").list();
        }
        if (i == 10) {
            try {
                this.sessionFactory.openSession().createQuery("delete Review review where review.id='" + review.getId() + "'").executeUpdate();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
            return this.sessionFactory.openSession().createQuery("from Review review where review.id='" + review.getId() + "'").list();
        }
        return null;
    }
}
