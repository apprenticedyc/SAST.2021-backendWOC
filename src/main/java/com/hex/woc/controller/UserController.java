package com.hex.woc.controller;

import com.hex.woc.Service.User.UserServiceImpl;
import com.hex.woc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hex
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //该注解可以对类成员变量、方法以及构造函数进行标注，完成自动装配工作
    @Autowired
    private UserServiceImpl userService;

@PostMapping("/login")
    public String login(User user){
    return userService.login(user);
}

    @PostMapping("/upload")
   public String uploadUser(User user){
    return userService.uploadUser(user);
    }
    /**
     * 解决查询数据库中文出现乱码问题
     * @return
     */
    @RequestMapping(value = "/alluser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<User> findAll() {
        return userService.selectAll();

    }

}
