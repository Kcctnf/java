package com.ming.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/showcookieServlet")
public class ShowCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.append("<html>")
                .append("<head><title>CookieTest</title></head>")
                .append("<h2>show cookie Info</h2><br>")

                .append("<table border='1' align='center'>")
                .append("<tr>")
                .append("<td>CookieName</td>")
                .append("<td>CookieValue</td>")
                .append("</tr>");

                Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    Cookie cookie = null;
                    for(int i=0; i<cookies.length;i++){
                        cookie = cookies[i];
                        out.append("<tr>")
                                .append("<td>'"+cookie.getName()+"'</td>")
                                .append("<td>'"+cookie.getValue()+"'</td>")
                                .append("</tr>");

                    }
                }

                out.append("</table>")

                .append("</html>");
    }

}
