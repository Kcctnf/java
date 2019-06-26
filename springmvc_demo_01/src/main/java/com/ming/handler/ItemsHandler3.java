package com.ming.handler;

import com.ming.po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemsHandler3 {

    @RequestMapping(value = "/xiaoming.action")
    public ModelAndView mySelfQueryItemsFunction(){
        // 模拟数据库数据
        List<Items> itemsList = new ArrayList<Items>();

        Items items_1 = new Items();
        //items_1.setId();
        items_1.setName("AAAAAA");
        items_1.setPrice(3000d);
        items_1.setDetail("laptop");
        items_1.setCreatetime(new Date());

        Items items_2 = new Items();
        //items_1.setId();
        items_2.setName("CCCCC");
        items_2.setPrice(13000d);
        items_2.setDetail("laptop");
        items_2.setCreatetime(new Date());

        itemsList.add(items_1);
        itemsList.add(items_2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsListKey",itemsList);
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }
}
