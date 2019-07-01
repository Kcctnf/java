package com.ming;

import com.ming.mapper.ItemsCustomMapper;
import com.ming.po.Items;
import com.ming.po.ItemsEx;
import com.ming.po.ItemsVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest2 {

   private ApplicationContext applicationContext = null;
    @Before
    public void initFun() throws Exception{
        applicationContext =
                new ClassPathXmlApplicationContext("spring/applicationContext-mapper.xml");
    }

    @Test
    public void testQueryItemsByName() throws Exception{
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //ItemsCustomMapper itemsCustomMapper = sqlSession.getMapper(ItemsCustomMapper.class);
        ItemsCustomMapper itemsCustomMapper = (ItemsCustomMapper)applicationContext.getBean("itemsCustomMapper");
        Items items = new Items();
        items.setName("len");
        ItemsVO itemsVO = new ItemsVO();
        itemsVO.setItems(items);
        List<ItemsEx>  itemsExList = itemsCustomMapper.queryItemsByName(itemsVO);
        System.out.println(itemsExList);
    }

}
