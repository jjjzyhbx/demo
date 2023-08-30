package com.Chlin.blog.controller;


import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.UserMapper;
import com.Chlin.blog.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public String login(@RequestBody String jsonData, HttpServletResponse resp) {
        User user = gson.fromJson(jsonData, User.class);
        if (userService.login(userMapper, user)) {
            if(user.isRememberpassword()) {
                Cookie rememberPasswordCookie = new Cookie("password", user.getPassword());
                rememberPasswordCookie.setMaxAge(30 * 24 * 60 * 60);
                // 设置 Cookie 的过期时间为一年
                resp.addCookie(rememberPasswordCookie);
            }
            // 登录成功时设置 Cookie
            Cookie idCookie = new Cookie("id", user.getStudentId());
            resp.addCookie(idCookie);

            return "{\"value3\":true}";
        } else {
            return "{\"value3\":false}";
        }
    }

    /**
     * 记住密码，
     * 返回密码
      */
    @PostMapping("/remember")
    public String rememberPassword(@RequestBody String jsonData){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = gson.fromJson(jsonData, User.class);

//        System.out.println(user.getStudentId()+"???"+jsonData);
         User user1 = userService.rememberPassword(request, user);

        System.out.println(user1.getPassword());
        return gson.toJson(user1);
    }


    /**
     * 注册
     */
    @PostMapping("/register")
    public String register(@RequestBody String jsonData){
        User user = gson.fromJson(jsonData, User.class);
        System.out.println(user.toString()+"+000");
         int register = userService.register(userMapper, user);
        if(register!=0){
            return "{\"value4\":true}";
        }else {
            return "{\"value4\":false}";
        }
    }

    /**
     * 主页加载个人信息
     * @return
     */
    private User loadMassage(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        val onlineUsers = (User)session.getAttribute("onlineUsers");
        return onlineUsers;
    }
    @PostMapping("/loadMassage")
    public String loadMyMassage(){
        return gson.toJson(loadMassage());
    }

    /**
     * 一个更新个人信息的控制插件
     * @param jsonData
     * @return
     */
    @PostMapping("/newUserMassage")
    public ResponseEntity<String> upDataMassage(@RequestBody String jsonData) {
        User user = gson.fromJson(jsonData, User.class);
        System.out.println("+"+user.toString());

         val user1 = loadMassage();
         if(user1.getStudentId().equals(user.getStudentId())){
             user.setId(user1.getId());
             System.out.println("001"+user1.toString());
         }
        // 执行更新操作
        final val i = userService.upUserMassage(userMapper, user);

        // 根据更新结果返回不同的响应
        if (i!=0) {
            return ResponseEntity.ok("修改成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("修改失败");
        }
    }
}

