package com.ming.mapper;

import com.ming.po.User;

import java.util.List;

/**
 * 在开发当中，你只需要去写接口即可，接口的实现类
 * 由mybaits的动态代理对象去帮你实现
 * 但是，你需要遵循一定的规则：(很重要)
 * 1,  mapper.xml文件中的namespace必须是接口所在包的全限定名
 * 2,  接口的命名以xxxmapper结束
 * 3,  接口中方法的名称是mapper.xml文件中StatementID的名称
 * 4,  接口中方法的返回值是mapper.xml文件中statement的resultType
 * 5,  接口中方法的参数是mapper.xml文件中statement的parameterType
 */
public interface UserMapper {
    //根据ID查询
    public User queryUserById(int id) throws Exception;
    //根据名称查询
    public List<User> queryUserByName2(String name) throws Exception;

}
