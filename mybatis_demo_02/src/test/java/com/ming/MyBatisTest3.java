package com.ming;

import com.ming.mapper.ItemsMapper;
import com.ming.po.Items;
import com.ming.po.User;
import com.ming.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest3 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInit() {
        String file = "sqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user  = userMapper.queryUserById(1);
            System.out.println(user);
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryItemsById(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
            Items items = itemsMapper.queryItemsById(7);
            System.out.println(items);
            sqlSession.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
