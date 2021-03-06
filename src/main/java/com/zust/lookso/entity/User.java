package com.zust.lookso.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/19
 * 时 间： 16:36
 * 项 目： LookSo
 * 描 述：用户实体
 */

@Entity
@Table(name = "user")
public class User implements Serializable {
    int id;
    int type;
    String nickname;
    String name;
    String password;
    int sex;
    String head;
    String description;
    int level;
    int status;

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "user_nick")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name = "user_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "user_pwd")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Column(name = "user_head")
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Column(name = "user_desc")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "user_level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Column(name = "user_status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
