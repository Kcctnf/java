package com.ming.mapper;

import com.ming.bz.UserBZ;
import com.ming.po.User;
import com.ming.po.UserEx;

import java.util.List;

public interface UserMapper {

//    public User queryUserById(int id) throws Exception;
    // public List<User> queryUserByName2(String name) throws Exception;
    public List<UserEx> queryUserBySexAndName(UserEx userEx) throws Exception;
    //测试动态SQL
    public List<User>  queryMoreId(UserBZ userBZ)throws  Exception;

    public List<User> queryMoreId2(UserBZ userBZ) throws Exception;

    public List<User>  queryUserByDifferent(UserEx userEx) throws Exception;

    public User queryUserResultMap(int id) throws Exception;

    public List<User> queryUserItems() throws Exception;

    public User queryUserById(int id) throws Exception;

    //更新
    public void modifyUser(User user) throws Exception;


}
