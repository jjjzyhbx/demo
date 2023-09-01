package com.Chlin.blog.controller;

import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.entity.User;
import com.Chlin.blog.service.OrderService;
import com.Chlin.blog.service.impl.OrderServiceImpl;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/blog")
public class Controller {

    @GetMapping("/hello")
    String test(){
        return "0000";
    }

    Gson gson=new Gson();
    @Autowired
    OrderService orderService=new OrderServiceImpl();

    /**
     * 添加到购物车操作
     * 1.返回当前的选中的菜，
     * 2.获取当前在线操作的用户
     * 3.创造一个订单
     * @param jsonData
     * @param request
     * @return
     */
    @PostMapping("/addShopping")
    public ResponseEntity<String> addShopping(@RequestBody String jsonData, HttpServletRequest request){
        System.out.println("加入购物车");
        HttpSession session=request.getSession();
        val onlineUsers = (User)session.getAttribute("onlineUsers");
        System.out.println("加入购物车在线"+onlineUsers.toString());
        Dish dish=gson.fromJson(jsonData,Dish.class);
         val order = orderService.createOrder(onlineUsers, dish);
         val save = orderService.save(order);
        if (save) {
            return ResponseEntity.ok("添加成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加失败");
        }
    }
}
