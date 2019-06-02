package com.dong.vo;

/**
 * Author : dong
 * Time:2019/5/29
 */
/**
 * VO  : Value Obejct
 * POJO: 简单的（setter/getter）原始的（不继承，不实现）Java对象
 */
public class User {

    private int userid;

    private String username;

    private String password;

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
