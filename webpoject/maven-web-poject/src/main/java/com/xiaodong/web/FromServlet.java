package com.xiaodong.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author : dong
 * Time:2019/5/13
 */
public class FromServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset = utf-8");

        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset = 'utf-8'>")
                .append("<title>From</title>")
                .append("<head>")
                .append("<body>")
                .append("<form method = 'POST'  action= '/form'>")
                .append("请输出姓名：")
                .append("<input name = 'name' type = 'text' value = ''/>")
                .append("<input type = 'submit' value = '提交'>")
                .append("</form>")
                .append("</body>")
                .append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.拿到请求参数
        //2.调用业务逻辑进行判断
        //3.返回相应的结果
        String name = req.getParameter("name");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>Form</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append("你好，欢迎您")
                .append(name)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

    }



}
