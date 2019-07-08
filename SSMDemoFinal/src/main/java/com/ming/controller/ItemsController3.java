package com.ming.controller;


import com.ming.po.Items;
import com.ming.po.ItemsCustom;
import com.ming.po.ItemsVO;
import com.ming.service.ItemsService;
import com.ming.service.ItemsServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ItemsController3 {

    @Autowired
    private ItemsService itemsService;

    /**
     * 全查
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/queryItemsList")
    public void queryItemsList(HttpServletRequest request,
                               HttpServletResponse response, ItemsVO itemsVO) throws Exception{

        response.setContentType("text/html;charset=UTF-8");

        List<ItemsCustom> itemsCustomList =  itemsService.queryItemsByName(itemsVO);
        request.setAttribute("itemslistKey",itemsCustomList);
        request.getRequestDispatcher("/WEB-INF/jsp/showitems.jsp").forward(request,response);
    }

    /**
     * items show edit page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editshowfun")
    public ModelAndView editShowFun(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        ItemsCustom itemsCustom;
        //做判断
        String checkbox_seleItems = request.getParameter("selItem");

        if(checkbox_seleItems == null){
            String id = request.getParameter("id");
            itemsCustom = itemsService.findItemsById(Integer.parseInt(id));
        }else{
            int chckBox_id = Integer.parseInt(checkbox_seleItems);
            itemsCustom = itemsService.findItemsById(chckBox_id);
        }

        //转发
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustomKey",itemsCustom);
        modelAndView.setViewName("editshow");
        return modelAndView;
    }


    /***
     * real modify
     */
    @RequestMapping(value = "editShowCommitFun")
    public String editShowCommitFun(HttpServletRequest request,
                                    @Param("id") Integer id,
                                    ItemsCustom itemsCustom,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=UTF-8");

        itemsService.updateItems(id,itemsCustom);
        return "forward:queryItemsList.action";
       //request.getRequestDispatcher("arvin.action").forward(request,response);
    }

    /**
     * 去到添加页面
     */
    @RequestMapping("addItems")
    public String addItems(HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        return "forward:/WEB-INF/jsp/addItems.jsp";
    }

    /**
     * 参数绑定
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addItemsSubmit")
    public String addItemsSubmit(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        //获取表单参数
        String itemsName = request.getParameter("name");
        String itemsPrice = request.getParameter("price");
        double itemsPrice_double = Double.parseDouble(itemsPrice);
        String itemsDetail = request.getParameter("detail");

        ItemsCustom ic = new ItemsCustom();
        ic.setName(itemsName);
        ic.setPrice(itemsPrice_double);
        ic.setDetail(itemsDetail);
        //调用业务逻辑
        itemsService.addItems(ic);
        return "forward:queryItemsList.action";
    }
    /**
     * 单个删除
     */
    @RequestMapping(value = "/deleteSingle")
    public String deleteSingle(@RequestParam("id") Integer myId,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        //1
        //2
        itemsService.moveItemsByIdentify(myId);
        //3
        return "forward:queryItemsList.action";
    }

    /***
     * 删除(通过多个ID)
     */
    @RequestMapping(value = "deleteIds")
    public void deleteItemsByIds(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        String [] ids = request.getParameterValues("selItem");
        //How do I to do it? --- convert string array to integer array
        Integer [] ids_int_array = new Integer[ids.length];
        for(int i = 0; i < ids.length; i++){
            ids_int_array[i] = Integer.valueOf(ids[i]);
        }
        itemsService.moveItemsByIdentifies(ids_int_array);
        request.getRequestDispatcher("queryItemsList.action").forward(request,response);
    }

}
