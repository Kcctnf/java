package com.dong.service;

/**
 * Author : dong
 * Time:2019/5/29
 */

import com.dong.biz.DbBiz;
import com.dong.vo.User;

import java.util.List;

/**
 * 模型层(M)
 */
public class UserService {

    private DbBiz dbBiz = new DbBiz();

    public List<User> queryUserFunc(){
        return dbBiz.queryListForUserFun();
    }
}
