package com.dong.controll;

/**
 * Author : dong
 * Time:2019/5/29
 */
import com.dong.service.UserService;
import com.dong.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;


@WebServlet(urlPatterns = "/handlerServlet")
public class HandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //1 *****************************获得请求参数******************************************
//        String param_username = request.getParameter("username");
//        String param_password = request.getParameter("password");
        //VO
//        User user = new User();
//        user.setUsername(param_username);
//        user.setPassword(param_password);


        //2 *****************************调用Service层(即模型层)******************************************
        UserService userService = new UserService();
        List<User> userList = userService.queryUserFunc();


        //3*****************************转向到其他的Web组件(jsp)******************************************
        request.getSession().setAttribute("userList_key", userList);
        request.getRequestDispatcher("showdbinfo.jsp").forward(request, response);//请求转发

    }
}

