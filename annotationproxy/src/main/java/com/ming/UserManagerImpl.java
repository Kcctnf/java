package com.ming;

/**
 * TargetObject
 */
public class UserManagerImpl implements IUserManager {
    public void addUser(String username, String password) {
        System.out.println("==========UserManagerImpl.addUser()========");
    }

    public boolean delUser(int id) {

        System.out.println("==========UserManagerImpl.delUser()========");
        return false;
    }

    public boolean modifyUser(int id, String username, String password) {

        System.out.println("==========UserManagerImpl.modifyUser()========");
        return false;
    }

    public String queryUser(int id) {
        System.out.println("==========UserManagerImpl.queryUser()========");
        return null;
    }

}
