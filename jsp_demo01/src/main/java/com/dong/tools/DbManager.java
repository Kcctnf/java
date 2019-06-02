package com.dong.tools;

/**
 * Author : dong
 * Time:2019/5/29
 */
import java.sql.*;

public class DbManager {

    private String username = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/jspdb";
    private String driver = "com.mysql.jdbc.Driver";

    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;

    public DbManager(){

    }

    /**
     * get tools connection
     * Obtained Connection what you will get in.
     * @return
     */
    public  Connection getConnection(){
        try {
            Class.forName(driver);
            System.out.println("loading driver prosperity............");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("connection tools success.........");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * query
     * @param strSql
     * @return
     */
    public ResultSet queryFunction(String strSql){
        try {
            conn = this.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(strSql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * update
     * @param strSql
     * @return
     */
    public int NonQueryFunctionForUpdate(String strSql){
        int flag = 0;
        try {
            conn = this.getConnection();
            state = conn.createStatement();
            flag = state.executeUpdate(strSql);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * add or del
     * @param strSql
     * @return
     */
    public boolean NonQueryFunctionForAddAndDel(String strSql){
        boolean flag = false;
        try {
            conn = this.getConnection();
            state = conn.createStatement();
            flag = state.execute(strSql);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void closeDB(){
        try {
            if(rs != null)rs.close();
            if(state != null) state.close();
            if(conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

