package com.Chlin.blog.controller;


import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.UserMapper;
import com.Chlin.blog.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@RestController
@RequestMapping("/blog/user")
public class UserController {
   private Gson gson = new Gson();
   @Autowired
   private UserMapper userMapper;
   private UserServiceImpl userService=new UserServiceImpl();
    /**
     * 用户登录
     * 接受用户名密码，返回判断是否正确
     * 返回格式{value3:true}
     */
    @PostMapping("/login")
   public String longin(@RequestBody String jsonData){
        System.out.println(jsonData);

                // 使用 data 对象进行相应的处理
                // ...
        User user = gson.fromJson(jsonData, User.class);
        System.out.println(user.toString());
        if(userService.login(userMapper,user)){

            return "{\"value3\":true}";
        }else {
            return "{\"value3\":false}";
        }

        }



}

