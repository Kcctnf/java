

package com.xiaodong.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author : dong
 * Time:2019/5/13
 */

public class ChanceServlet1 extends HttpServlet {

    private int chanceNumber;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        chanceNumber = Integer.parseInt(config.getInitParameter("chanceNumber"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf - 8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset = \"utf-8\">")
                .append("<head>")
                .append("<body>");
        String name = req.getParameter("name");
        if (chanceNumber > 0) {
            chanceNumber = chanceNumber - 1;
            writer.append("<h1>")
                    .append(name)
                    .append("剩余")
                    .append(String.valueOf(chanceNumber))
                    .append("次机会")
                    .append("</h1>");
        } else {
            writer.append("<h1>")
                    .append(name)
                    .append("没机会了")
                    .append("</h1>");
        }
        writer.append("</body>").append("</html>");
    }
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }
}

