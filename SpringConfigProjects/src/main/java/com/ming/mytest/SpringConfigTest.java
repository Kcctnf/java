package com.ming.mytest;

import com.ming.config.SpringConfig;
import com.ming.service.UserService;
import com.ming.vo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringConfigTest {

    public static void main(String[] args) {
        // 通过Java配置来实例化Spring容器
        //ApplicationContext context = new ClassPathXmlApplicationContext("aaaaa.xml")
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        //context.getBean("xxxxx");

        //访问service层
        UserService userService = context.getBean(UserService.class);
        //访问Dao层
        List<User> userList =  userService.queryUserList_service();
        for (User user: userList) {
            System.out.println(user.getUsername() + ", " + user.getPassword() + ", " + user.getPassword());
        }

    }
}
