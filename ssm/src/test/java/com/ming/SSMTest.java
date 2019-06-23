package com.ming;

import com.ming.mapper.UserMapper;
import com.ming.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SSMTest {

    private ApplicationContext applicationContext = null;
    @Before
    public void initfun(){
        applicationContext =
                new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
    }
//    @Test
//    public void testqueryUserById() throws Exception{
//        UserDAOImpl userDAOImpl = (UserDAOImpl) applicationContext.getBean("userdaoImpl");
//        User user = userDAOImpl.myQueryUserByIdFun(1);
//        System.out.println(user);
//    }
    @Test
    public void testqueryUserByIdBaseOnMapperProxy() throws Exception{
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.queryUserById(1);
        System.out.println(user);
    }

}
