package com.zust.lookso.dto;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/5
 * 时 间： 20:46
 * 项 目： LookSo
 * 描 述：
 */
public class CommentDto {
    int id;
    int uid;
    String head;
    int level;
    String user;
    String content;
    int score;
    String time;
    float grade;

    public CommentDto(int id, int uid, String head, int level, String user, String content, int score, String time) {
        this.id = id;
        this.uid = uid;
        this.head = head;
        this.level = level;
        this.user = user;
        this.content = content;
        this.score = score;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
