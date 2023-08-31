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

//   private void setCookies(String id,String password,Cookie cookie){
//
//
//   }
    /**
     * 用户登录
     * 接受用户名密码，返回判断是否正确
     * 返回格式{value3:true}
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String jsonData, HttpServletResponse resp) {
        User user1=new User();
        User user = gson.fromJson(jsonData, User.class);
        System.out.println(user.toString()+"欢迎判断");
        if (userService.login(userMapper, user)) {
//            if(user.isRememberpassword()) {
//                user1 = loadMassage();
//                System.out.println("在线"+user1.toString());
//                Cookie PasswordCookie = new Cookie("password", user1.getPassword());
//                PasswordCookie.setMaxAge(30 * 24 * 60 * 60);
//                // 设置 Cookie 的过期时间为一年
//                resp.addCookie(PasswordCookie);
//            }
            // 登录成功时设置 Cookie
                user1 = loadMassage();
                System.out.println("在线"+user1.toString());
                Cookie PasswordCookie = new Cookie("password", user1.getPassword());
                PasswordCookie.setMaxAge(30 * 24 * 60 * 60);
                // 设置 Cookie 的过期时间为一年
                resp.addCookie(PasswordCookie);
            Cookie idCookie = new Cookie("id", user1.getStudentId());
            resp.addCookie(idCookie);

//            return "{\"value3\":true}";
            return ResponseEntity.ok("登录成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("登录失败");
//            return "{\"value3\":false}";
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
        User onlineUsers = (User)session.getAttribute("onlineUsers");
        return onlineUsers;
    }
    @PostMapping("/loadLogin")
    public String loadLogin(){
        final val user = loadMassage();
        if(user!=null){
            return gson.toJson(user);
        }else {
            return "";
        }
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
        // 执行更新操作
        final val i = userService.upUserMassage(userMapper, user);

        // 根据更新结果返回不同的响应
        if (i!=0) {
            return ResponseEntity.ok("修改成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("修改失败");
        }
    }

    /**
     * 充值
     * @param jsonData
     * @return
     */
    @PostMapping("/recharge")
    public ResponseEntity<String> RechargeMoney(@RequestBody String jsonData){
        User user = gson.fromJson(jsonData, User.class);
        System.out.println("+"+user.toString());
        // 执行更新操作
        final val i = userService.upUserBalance(userMapper, user);
        // 根据更新结果返回不同的响应
        if (i!=0) {
            return ResponseEntity.ok("修改成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("修改失败");
        }
    }
}

