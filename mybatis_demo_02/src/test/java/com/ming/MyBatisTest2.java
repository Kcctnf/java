//package com.ming;
//
//import com.ming.dao.UserDAO;
//import com.ming.po.User;
//import UserMapper;
//import com.ming.service.UserManagerImpl;
//import org.junit.Test;
//
//import java.util.Date;
//import java.util.List;
//
//public class MyBatisTest2 {
//
//
//    @Test
//    public void testQueryUserById(){
//        UserMapper iusermanager = new UserManagerImpl(new UserDAO());
//        try {
//            User user =  iusermanager.queryUserById(1);
//            System.out.println(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testQueryUserByName(){
//        UserMapper iusermanager = new UserManagerImpl(new UserDAO());
//        try {
//            List<User> userList =  iusermanager.queryUserByName("vin");
//            System.out.println(userList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testAddUser(){
//        UserMapper iusermanager = new UserManagerImpl(new UserDAO());
//        try {
//            User user = new User();
//            user.setUsername("SSSS");
//            user.setBirthday(new Date());
//            user.setSex(1);
//            user.setAddress("TTJJ");
//            int resultInt =  iusermanager.addUser(user);
//
//            System.out.println(resultInt);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
