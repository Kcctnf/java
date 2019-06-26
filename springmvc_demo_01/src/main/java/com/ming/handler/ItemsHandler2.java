package com.ming.handler;

import com.ming.po.Items;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsHandler2 implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        // 模拟数据库数据
        List<Items> itemsList = new ArrayList<Items>();

        Items items_1 = new Items();
        //items_1.setId();
        items_1.setName("HuaWei protable");
        items_1.setPrice(3000d);
        items_1.setDetail("laptop");
        items_1.setCreatetime(new Date());

        Items items_2 = new Items();
        //items_1.setId();
        items_2.setName("Lenovo protable");
        items_2.setPrice(13000d);
        items_2.setDetail("laptop");
        items_2.setCreatetime(new Date());

        itemsList.add(items_1);
        itemsList.add(items_2);

        //自己来处理返回值

        request.setAttribute("itemsListKey",itemsList);
        request.getRequestDispatcher("/jsp/itemsList.jsp").forward(request,response);

    }
}
