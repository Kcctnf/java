package com.small.project;


/**
 * Author : dong
 * Time:2019/5/18
 */
import com.service.QueryService;
import com.vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/handlerServlet")
public class HandleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // to do sth
        //1, 获取用户请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        QueryService queryService = new QueryService();

        List<UserInfo> userInfoList = queryService.queryDb(userInfo);
        if (userInfoList != null) {
            req.getSession().setAttribute("key_usernfolist", userInfoList);
            req.getRequestDispatcher("successServlet").forward(req, resp);
        } else {
            req.getRequestDispatcher("failureServlet").forward(req, resp);
        }
    }
}


/*
//也是正确的：
        //2, 调用业务逻辑进行判断
        req.getSession().setAttribute("key_username",username);
        req.getSession().setAttribute("key_password",password);

        //3，返回相应的结果
        req.getRequestDispatcher("resultServlet").forward(req,resp);
    }
}
*/