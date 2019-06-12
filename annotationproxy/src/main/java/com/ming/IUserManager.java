package com.ming;

/**
 * 主营业务
 */
public interface IUserManager {

    public void addUser(String username, String password);

    public boolean delUser(int id);

    public boolean modifyUser(int id, String username, String password);

    public String queryUser(int id);

}
