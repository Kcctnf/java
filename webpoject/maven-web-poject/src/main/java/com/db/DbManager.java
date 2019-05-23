package com.db;

import java.sql.*;

/**
 * Author : dong
 * Time:2019/5/20
 */

/**
 * 配置数据库连接类
 */
public class DbManager {
    public String driver = "com.mysql.jdbc.Driver";

    public String username = "root";

    public String password = "root";

    public String url = "jdbc:mysql://127.0.0.1:3306/servletdb";

    public Connection conn = null;

    public Statement state = null;
    public ResultSet rs = null;

    public DbManager(){

    }

    public Connection getConnection(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("connection success.....");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet queryExecuteFun(String strSql)  {

        try {
            state = conn.createStatement();
            rs = state.executeQuery(strSql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
   public void closeDb(){
        try{
            if(rs != null) rs.close();
            if(state != null) state.close();
            if(conn != null) conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
   }
}
