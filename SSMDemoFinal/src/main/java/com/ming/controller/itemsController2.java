package com.ming.controller;

import com.ming.po.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class itemsController2 implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {

        List<Items> itemsList = new ArrayList<Items>();
        Items items1 = new Items();
        items1.setName("arvin");
        items1.setCreatetime(new Date());
        items1.setDetail("arvin who is a good man");

        Items items2 = new Items();
        items2.setName("arvin2");
        items2.setCreatetime(new Date());
        items2.setDetail("arvin who is a good man");

        itemsList.add(items1);
        itemsList.add(items2);

        request.setAttribute("itemslistKey",itemsList);

        //How do i to do it?
        request.getRequestDispatcher("/WEB-INF/jsp/showitems.jsp").forward(request,response);

    }


}
