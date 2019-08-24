package servlet;

import db.DbConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author : dong
 * Time:2019/8/23
 */
@WebServlet(name = "/loginServer")
public class LoginServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String admin = req.getParameter("admin");
        String pwd = req.getParameter("pwd");
        if (admin.equals("admin") && pwd.equals("123")) {
            Connection connection = DbConnect.getConnection();
            String sql = "SELECT * FROM STUDENT";
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                HttpSession httpSession = req.getSession();
//                设置session有效时间为两小时
                httpSession.setMaxInactiveInterval(7200);
                httpSession.setAttribute("resultSet", resultSet);
                resp.sendRedirect("main.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
