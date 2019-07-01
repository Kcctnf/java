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

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private  SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void initFun() throws Exception{
        String file = "mybatis/sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(file);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void testQueryItemsByName() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemsCustomMapper itemsCustomMapper = sqlSession.getMapper(ItemsCustomMapper.class);
        Items items = new Items();
        items.setName("len");
        ItemsVO itemsVO = new ItemsVO();
        itemsVO.setItems(items);
        List<ItemsEx>  itemsExList = itemsCustomMapper.queryItemsByName(itemsVO);
        System.out.println(itemsExList);
    }

}
