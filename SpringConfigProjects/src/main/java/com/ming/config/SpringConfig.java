package com.ming.config;

import com.ming.dao.UserDAO;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// applicationContext.xml
// what will we to do in applicationContext.xml?


@Configuration
@ComponentScan(basePackages = "com.ming")
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String myDriver; //myDriver == com.mysql.jdbc.Driver (5.x)

    @Value("${jdbc.url}")
    private String myUrl;

    @Value("${jdbc.username}")
    private String myUsername;

    @Value("${jdbc.password}")
    private String myPassword;



    /**
     * <bean id="userDAO" class="com.ming.UserDAO"/>
     *  ApplicationContext context = new ClassPathXmlApplicationContext("aaaaa.xml")
     *  context.getBean("id_value");
     *
     * @return
     */
    @Bean //代表是一个<bean/>标签
    public UserDAO userDAO(){
        UserDAO userDAO = new UserDAO();
        return userDAO;
    }

    @Bean()
    public BasicDataSource basicDataSource (){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(myDriver);
        basicDataSource.setUrl(myUrl);
        basicDataSource.setUsername(myUsername);
        basicDataSource.setPassword(myPassword);
        basicDataSource.setMaxActive(1000);
        basicDataSource.setMaxIdle(30);
        return basicDataSource;
    }


}
