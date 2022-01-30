package com.hex.woc.Service.User;

import com.hex.woc.Service.User.UserService;
import com.hex.woc.entity.User;
import com.hex.woc.mapper.UserMapper;
import com.hex.woc.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hex
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    //该注解可以对类成员变量、方法以及构造函数进行标注，完成自动装配工作
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Utility utility;


    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }


    /**
     * 完成注册功能
     * 选做：对密码进行加密处理
     *
     * @param user
     */
    @Override
    public String uploadUser(User user) {
        User userExist = userMapper.selectByName(user.getUsername());
        if (user.getUsername().equals("")) {
            return "用户名不能为空!";
        }
        if (user.getPassword().equals("")) {
            return "密码不能为空!";
        }
        if (userExist != null) {
            return "用户已经存在!";
        } else {
            userMapper.save(user);
        }
        return "注册成功!";
    }

    /**
     * 完成登录功能
     *
     * @param user
     * @return 是否登录成功
     */
    @Override
    public String login(User user) {
        User user1 = userMapper.selectByName(user.getUsername());
        if (user1 == null) {
            return "该用户不存在!";
        }
        if (!(user1.getPassword().equals(user.getPassword()))) {
            return "密码错误!";
        }
        return "恭喜你,登陆成功!";
    }
}
