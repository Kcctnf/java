package com.ming.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/urlServlet")
public class URLServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession mySession = request.getSession(true);
        out.append("<html>")
                .append("<head><title>cookie</title></head>")
                .append("<body>")
                .append("ISNewSession = " + mySession.isNew() +"</br>")
                .append("SessionID = " + mySession.getId()+"</br>")
                .append("Session CreateTime = " + new Date(mySession.getCreationTime())+"</br>")
                .append("Session last Access Time = " + new Date(mySession.getLastAccessedTime())+"</br>");


        out.append("session id whether or not cookie:  " + request.isRequestedSessionIdFromCookie() + "</br>")
                .append("session id whether or not URL : " + request.isRequestedSessionIdFromURL() + "</br>")
                .append("<a href='" + response.encodeURL(request.getRequestURL().toString()) + "'>Test(URLRewrite)</a></br>")
                .append("<a href='" + request.getRequestURL().toString() + "'>Test2(Non URL)</a></br>")
                .append("</body>")
                .append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
