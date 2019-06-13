package com.dong;

/**
 * Author : dong
 * Time:2019/6/12
 */

import com.dong.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis 的API
 * 1.SqlSessionFactory
 * 2.SqlSession
 */
public class MybatisTest {

    public SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInitial(){

        String strFile = "sqlmapconfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(strFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testQueryUserById(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            User user = (User) sqlSession.selectOne("mytest.queryUserById",1);
            System.out.println(user);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();//别忘了关我呦
        }
    }
}
