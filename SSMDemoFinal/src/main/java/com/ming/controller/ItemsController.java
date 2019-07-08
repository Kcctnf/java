package com.ming.controller;


import com.ming.po.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 处理器，控制器
 * 适应适配器的规则(适配要求实现Controller接口)
 * <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
 *        @Override
 *    public boolean supports(Object handler) {
 * 		return (handler instanceof Controller);
 *    }
 *    @FunctionalInterface
 * public interface Controller {
 *
 */
public class ItemsController  implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        /**
         * 模拟数据
         */
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

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemslistKey",itemsList);
        modelAndView.setViewName("showitems");//配置视图解析器
        //modelAndView.setViewName("/WEB-INF/jsp/showitems.jsp");
        return modelAndView;
    }
}
