package com.vo;

/**
 * Author : dong
 * Time:2019/5/20
 */
public class UserInfo {

    private String username;
    private String password;

    public UserInfo(){

    }


    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
