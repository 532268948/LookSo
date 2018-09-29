package com.zust.lookso.dao.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.dao.TopDao;
import com.zust.lookso.entity.Movie;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 21:16
 * 项 目： LookSo
 * 描 述：
 */
@Repository
@Qualifier("movieDao")
public class MovieDaoImpl implements CommonOperate, TopDao {

    @Autowired
    SessionFactory sessionFactory;

    private Movie movie;

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
     * @param i    0搜索电影 1分类电影 2所有电影 3分类电影总数 4电影详情 5分类推荐 6电影推荐 7搜索电影总数
     *             8(管理员)获取所有电影  9下架电影(管理员) 10恢复电影(管理员) 11获取电影总数(管理员)
     *             12上传电影(管理员) 13更新电影cover、slider(管理员)
     * @return
     */
    @Override
    public List Query(Object data, int i) {
        if (data != null) {
            movie = (Movie) data;
        }

        if (i == 0) {
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.name like '%" + movie.getName() + "%' and movie.status=0")
                    .setFirstResult(10 * movie.getId())
                    .setMaxResults(10)
                    .list();
        }
        if (i == 1) {
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.sort like '%" + movie.getSort() + "%' and movie.status=0")
                    .setFirstResult(10 * movie.getId())
                    .setMaxResults(10).list();
        }
        if (i == 2) {
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.status=0")
                    .setFirstResult(20 * movie.getId())
                    .setMaxResults(20)
                    .list();
        }
        if (i == 3) {
            return this.sessionFactory.openSession().createQuery("select count(*) from Movie movie where movie.sort like '%" + movie.getSort() + "%' and movie.status=0").list();
        }
        if (i == 4) {
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.id='" + movie.getId() + "' and movie.status=0").list();
        }
        if (i == 5) {
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.sort like '%" + movie.getSort() + "%' and movie.status=0")
                    .setMaxResults(6)
                    .list();
        }
        if (i == 6) {
            return this.sessionFactory.openSession().createQuery("from Movie movie , Review review where movie.id=review.movie and movie.status=0 " +
                    "group by review.movie order by avg(review.score)")
                    .setFirstResult(10 * movie.getId())
                    .setMaxResults(10)
                    .list();
        }
        if (i == 7) {
            return this.sessionFactory.openSession().createQuery("select count(*) from Movie movie where movie.name like '%" + movie.getName() + "%' and movie.status=0")
                    .list();
        }
        if (i == 8) {
            return this.sessionFactory.openSession().createQuery("from Movie movie order by movie.show desc")
                    .setFirstResult(10 * movie.getId())
                    .setMaxResults(10)
                    .list();
        }
        if (i == 9) {
            this.sessionFactory.openSession().createQuery("update Movie movie set movie.status=1 where movie.id='" + movie.getId() + "'").executeUpdate();
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.id='" + movie.getId() + "'").list();
        }

        if (i == 10) {
            this.sessionFactory.openSession().createQuery("update Movie movie set movie.status=0 where movie.id='" + movie.getId() + "'").executeUpdate();
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.id='" + movie.getId() + "'").list();
        }
        if (i == 11) {
            return this.sessionFactory.openSession().createQuery("select count(*) from Movie movie where movie.name like '%" + movie.getName() + "%'")
                    .list();
        }
        if (i == 12) {
            Integer id = (Integer) this.sessionFactory.openSession().save(movie);
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.id='" + movie.getId() + "'").list();
        }
        if (i == 13) {
            this.sessionFactory.openSession().createQuery("update Movie movie set movie.cover='" + movie.getCover() + "'," +
                    "movie.slider='" + movie.getSlider() + "' where movie.id='" + movie.getId() + "'").executeUpdate();
            return this.sessionFactory.openSession().createQuery("from Movie movie where movie.id='" + movie.getId() + "'").list();
        }
        return null;
    }

    @Override
    public List getTopMovie() {
        return this.sessionFactory.openSession().createQuery("from Movie")
                .setMaxResults(9)
                .list();
    }
}
