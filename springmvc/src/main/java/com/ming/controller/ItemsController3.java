package com.ming.controller;


import com.ming.vo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemsController3 {
    @RequestMapping(value = "/arvin")
    public void queryItemsList(HttpServletRequest request,
                               HttpServletResponse response) throws Exception{

        //调用Service层

//        List<Items> itemsList = new ArrayList<Items>();
//        Items items1 = new Items();
//        items1.setName("arvin");
//        items1.setCreatetime(new Date());
//        items1.setDetail("arvin who is a good man");
//
//        Items items2 = new Items();
//        items2.setName("arvin2");
//        items2.setCreatetime(new Date());
//        items2.setDetail("arvin who is a good man");
//
//        itemsList.add(items1);
//        itemsList.add(items2);
//
//        request.setAttribute("itemslistKey",itemsList);
//        request.getRequestDispatcher("/WEB-INF/jsp/showitems.jsp").forward(request,response);

    }

}
