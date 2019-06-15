package com.ming.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cookieServlet")
public class CookieServlet extends HttpServlet {

    //private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       //演示Cookie
        for(int i = 0;i < 3; i++) {
            Cookie cookie = new Cookie("cookieKey-"+i, "cookieValue-"+i);
            response.addCookie(cookie);

            cookie = new Cookie("persistenceCookieKey-"+ i,"persistenCookieValue-"+i);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
        }
        out.append("<html>")
                .append("<head><title>CookieTest</title></head>")
                .append("<h2>cookietest</h2><br>")
                .append("<a href='showcookieServlet'>go to next page show cookie infomation</a>")
                .append("</html>");
    }
}
