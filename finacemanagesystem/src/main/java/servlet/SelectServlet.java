package servlet;

import db.DbConnect;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author : dong
 * Time:2019/8/23
 */
@WebServlet(name = "selectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UnsupportedEncodingException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String sql = "SELECT * FROM STUDENT WHERE ID=?";
        Connection connection = DbConnect.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        Student student = null;
        try {
            try {
                preparedStatement = connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                String name = resultset.getString("name");
                String sex = resultset.getString("sex");
                String specialty = resultset.getString("specialty");
                String grade = resultset.getString("grade");
                student = new Student(Integer.parseInt(id), name, sex, specialty, grade);
            }
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("student", student);
            response.sendRedirect("stuEdit.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
