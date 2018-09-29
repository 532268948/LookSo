package com.zust.lookso.dao.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/28
 * 时 间： 21:49
 * 项 目： LookSo
 * 描 述：
 */
@Repository
@Qualifier("userDao")
public class UserDaoImpl implements CommonOperate {

    @Autowired
    SessionFactory sessionFactory;

    private User user;

    @Override
    public List Add(Object data) {
        user = (User) data;
        this.sessionFactory.openSession().save(user);
        return Query(user, 0);
    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public void Revise(Object data, int i) {

    }

    /**
     * @param data
     * @param i    0登录  1用户信息 2获取所有用户信息(管理员) 3封禁用户 4恢复用户 5验证用户是否被封禁 6修改用户文字信息
     *             7更新用户头像
     * @return
     */
    @Override
    public List Query(Object data, int i) {
        if (data != null) {
            user = (User) data;
        }
        if (i == 0) {
            return this.sessionFactory.openSession().createQuery("select new com.zust.lookso.dto.UserDto(user.type," +
                    "user.id,user.name,user.nickname,user.sex,user.head,user.level,user.description) from User user where" +
                    " user.name='" + user.getName() + "' and user.password='" + user.getPassword() + "' and user.status='0'").list();
        }
        if (i == 1) {
            return this.sessionFactory.openSession().createQuery("from User user where user.id='" + user.getId() + "'").list();
        }
        if (i == 2) {
            return this.sessionFactory.openSession().createQuery("from User user where user.type=0").list();
        }

        if (i == 3) {
            this.sessionFactory.openSession().createQuery("update User user set user.status='1' where " +
                    "user.id='" + user.getId() + "'").executeUpdate();
            return this.sessionFactory.openSession().createQuery("from User user where user.status='1' " +
                    "and user.id='" + user.getId() + "'").list();
        }

        if (i == 4) {
            this.sessionFactory.openSession().createQuery("update User user set user.status='0' where " +
                    "user.id='" + user.getId() + "'").executeUpdate();
            return this.sessionFactory.openSession().createQuery("from User user where user.status='0' " +
                    "and user.id='" + user.getId() + "'").list();
        }

        if (i == 5) {
            return this.sessionFactory.openSession().createQuery("from User user where user.name='" + user.getName() + "' " +
                    "and user.password='" + user.getPassword() + "' and user.status='1'").list();
        }

        if (i == 6) {
            this.sessionFactory.openSession().createQuery("update User user set user.nickname='" + user.getNickname() + "'," +
                    "user.sex='" + user.getSex() + "',user.description='" + user.getDescription() + "' where " +
                    "user.id='" + user.getId() + "'").executeUpdate();
            return this.sessionFactory.openSession().createQuery("from User user where user.id='" + user.getId() + "'").list();
        }
        if (i == 7) {
            this.sessionFactory.openSession().createQuery("update User user set user.head='" + user.getHead() + "' where " +
                    "user.id='" + user.getId() + "'").executeUpdate();
            return this.sessionFactory.openSession().createQuery("from User user where user.id='" + user.getId() + "'").list();
        }
        return null;
    }
}
