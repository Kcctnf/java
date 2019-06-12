package com.ming;

public class Client3 {

    public static void main(String[] args) {

        MyAspect myAspect = new MyAspect(new UserManagerImpl());
        //CreateDynamic cd = new CreateDynamic(new UserManagerImpl());
        //IUserManager iusermanager = (IUserManager) cd.newInstanceProxyObejctFuncion();
        IUserManager iusermanager = new UserManagerImpl();

        iusermanager.addUser("dd","22");

    }
}
