//package com.ming;
//
//
//import com.ming.po.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Date;
//import java.util.List;
//
///**
// * Mybatis API
// * SqlSessionFactory ;
// * SqlSession :线程不安全的  应该怎么做--->放入方法体呢
// */
//public class MyBatisTest {
//
//    private SqlSessionFactory sqlSessionFactory = null;
//
//    //private SqlSession sqlSession = null;  //线程不安全
//
//    @Before
//    public void testInit() {
//        String file = "sqlMapConfig.xml";
//        InputStream is = null;
//        try {
//            is = Resources.getResourceAsStream(file);
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testQueryUserById() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user =  sqlSession.selectOne("test.queryUserById",1);
//        System.out.println(user);
//        sqlSession.close();
//    }
//
//   /* @Test
//    public void testQueryUserByName() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> userList = sqlSession.selectList("test.queryUserByName","%vin%");
//        System.out.println(userList);
//        sqlSession.close();
//    }*/
//
//    @Test
//    public void testQueryUserByName() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> userList = sqlSession.selectList("test.queryUserByName2","vin");
//        System.out.println(userList);
//        sqlSession.close();
//    }
//
//    @Test
//    public void testAddUser() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user = new User();
//        user.setUsername("KKKKK");
//        user.setSex(1);
//        user.setBirthday(new Date());
//        user.setAddress("Tianjiang");
//
//        int resultValue =  sqlSession.insert("test.addUesr",user);
//        sqlSession.commit();
//        System.out.println("resultValue is = " + resultValue);
//        sqlSession.close();
//    }
//
//    @Test
//    public void testDeleteUser(){
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.delete("test.deleteUser",36);
//        sqlSession.commit();
//        sqlSession.close();
//    }
//@Test
//    public void testModifyUser(){
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user = new User();
//        user.setId(1);
//        user.setUsername("UUUUUU");
//        user.setSex(1);
//        user.setBirthday(new Date());
//        user.setAddress("Tianjiang");
//        sqlSession.update("test.modifyUser",user);
//        sqlSession.commit();
//        sqlSession.close();
//    }
//}
