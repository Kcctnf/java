package com.xiaodong.web;

/**
 * Author : dong
 * Time:2019/5/13
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/hello")
public class Servlet extends HttpServlet {
    /**
     * 初始化(tomcaat)
     * @throws ServletException
     */
//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.append("<html>")
                .append("<body>")
                .append("<p>第一个web")
                .append("</p>")
                .append("现在时间是:"+new Date())
                .append("</body>")
                .append("</html>");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

//    @Override
//    public void destroy() {
//        super.destroy();
//    }
}
