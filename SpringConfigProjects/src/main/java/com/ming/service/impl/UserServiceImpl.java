package com.ming.service.impl;

import com.ming.dao.UserDAO;
import com.ming.service.UserService;
import com.ming.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.UserDataHandler;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> queryUserList_service() {
        return userDAO.queryUserList();
    }
}
