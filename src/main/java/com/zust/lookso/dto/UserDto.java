package com.zust.lookso.dto;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/27
 * 时 间： 22:08
 * 项 目： LookSo
 * 描 述：
 */
public class UserDto {
    Integer userType;
    Integer userId;
    String userName;
    String userNick;
    Integer userSex;
    String userHead;
    Integer userLevel;
    String userDesc;

    public UserDto(Integer userType, Integer userId, String userName, String userNick, Integer userSex, String userHead, Integer userLevel, String userDesc) {
        this.userType = userType;
        this.userId = userId;
        this.userName = userName;
        this.userNick = userNick;
        this.userSex = userSex;
        this.userHead = userHead;
        this.userLevel = userLevel;
        this.userDesc = userDesc;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}
