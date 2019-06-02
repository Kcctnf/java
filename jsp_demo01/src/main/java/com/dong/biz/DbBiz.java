package com.dong.biz;

/**
 * Author : dong
 * Time:2019/5/29
 */

import com.dong.tools.DbManager;
import com.dong.vo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久层 P(Persistent)
 */
public class DbBiz {

    private DbManager db = null;

    //真正的访问数据库，写SQL语句在这里
    public List<User> queryListForUserFun() {
        List<User> userList = new ArrayList<User>();
        try {
            db = new DbManager();
            Connection conn = null;
            ResultSet rs = null;
            int db_id;
            String db_username = null;
            String db_password = null;
            conn = db.getConnection();
            //等待下节课改造
            String strSql = "select * from user";
            rs = db.queryFunction(strSql);

            while (rs.next()) {
                db_id = rs.getInt("userid");
                db_username = rs.getString("username");
                db_password = rs.getString("password");
                User user = new User();
                user.setUserid(db_id);
                user.setUsername(db_username);
                user.setPassword(db_password);
                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
