package com.ming.handler;

import com.ming.po.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Spring MVC
 * 2个控制器
 * 第一个：前端控制器(1个)
 * 第二个：业务逻辑控制器(m个)
 */
public class ItemsHandler implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        /**
         * 业务逻辑控制器
         * 1.  获取表单参数
         * 2， 调用业务逻辑层
         * 3， 转向到其他的web组件
         *
         */
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

        ModelAndView modelAndView = new ModelAndView();
        //request.setAttribute(key,value);
        modelAndView.addObject("itemsListKey",itemsList);
        //modelAndView.setViewName("/jsp/itemsList.jsp");
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }
}
