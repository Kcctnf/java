package com.ming.dao;

import com.ming.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 真正执行sql语句的地方
 * 也就是访问数据库的地方
 */
public class UserDAO {

    private  SqlSessionFactory sqlSessionFactory = null;

    public UserDAO(){
        String file = "sqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User queryUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user =  sqlSession.selectOne("test.queryUserById",1);
        sqlSession.close();
        return user;
    }

    public List<User> queryUserByName(String name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("test.queryUserByName2","vin");
        sqlSession.close();
        return userList;
    }

    public int addUser(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int resultValue =  sqlSession.insert("test.addUesr",user);
        sqlSession.commit();
        sqlSession.close();
        return resultValue;
    }

}
