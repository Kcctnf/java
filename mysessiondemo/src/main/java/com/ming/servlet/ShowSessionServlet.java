package com.ming.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/showSessionServlet")
public class ShowSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //sqlSession
        //有就用，没有就创建
        HttpSession session = request.getSession(true);
        String heading = null;
        /**
         * 计数器
         */
        Integer accessNum = (Integer) session.getAttribute("accessNum");
        if(accessNum == null){
            accessNum = new Integer(0);
            heading = "welcome newer";
        }else{
            accessNum = new Integer(accessNum.intValue()+ 1);//咋加
            heading = "welcome older";
        }
        session.setAttribute("accessNum",accessNum);

        out.append("<html>")
                .append("<head><title>cookie</title></head>")
                .append("<body>")
                .append("<h3>'"+heading+"'</h3>")
                .append("<table border='1' align='center'>")

                .append("<tr>")
                .append("<td>SessionType</td>")
                .append("<td>SessionValue</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>ID</td>")
                .append("<td>'"+session.getId()+"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>Create Time</td>")
                .append("<td>'"+new Date(session.getCreationTime()) +"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>Last Access Time</td>")
                .append("<td>'"+new Date(session.getLastAccessedTime())+"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>AccessTimes</td>")
                .append("<td>'"+accessNum+"'</td>")
                .append("</tr>")


                .append("</table>")
                .append("</body>")
                .append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

}
