package com.small.project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author : dong
 * Time:2019/5/20
 */
@WebServlet("/failureServlet")
public class FailureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer =  resp.getWriter();

        writer.append("<html>")
                .append("<head><title></title></head>")
                .append("<body>")
                .append("<font color='red' size='50px'>")
                .append("对不起，登录失败，<a href='mylogin'>点击回登录页面</a></br>")
                .append("</font>")
                .append("</body>")
                .append("</html>");

    }
}

