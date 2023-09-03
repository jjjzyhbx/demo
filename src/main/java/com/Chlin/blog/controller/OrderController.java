package com.Chlin.blog.controller;


import com.Chlin.blog.entity.Orders;
import com.Chlin.blog.entity.User;
import com.Chlin.blog.service.DishService;
import com.Chlin.blog.service.OrderService;
import com.Chlin.blog.service.UserService;
import com.Chlin.blog.service.impl.DishServiceImpl;
import com.Chlin.blog.service.impl.OrderServiceImpl;
import com.Chlin.blog.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@RestController
@RequestMapping("/blog/order")
public class OrderController {
    @Autowired
    OrderService orderService=new OrderServiceImpl();
    @Autowired
    DishService dishService=new DishServiceImpl();
    @Autowired
    UserService userService=new UserServiceImpl();

    Gson gson=new Gson();

    @PostMapping("/payment1")
    public ResponseEntity<String> payment(@RequestBody String json, HttpServletRequest request){

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("onlineUsers");
        System.out.println(user.toString());
        //获得当前选中的订单
        Orders orders=gson.fromJson(json,Orders.class);

        //查询数据库中的订单
         Orders orders1 = orderService.listByUseridAndDishId(orders);

         if(user.getBalance().compareTo(orders1.getPaidAmount())>0){
             final val subtract = user.getBalance().subtract(orders1.getAmount());
             user.setBalance(subtract);
             //订单完成，设置订单状态，更新订单完成时间
             orders1.setStatus(1);
             orders1.setCompleteTime(new Date());
             //跟新用户跟订单状态
             userService.saveOrUpdate(user);
             //更新在线用户数据
             session.setAttribute("onlineUsers",user);
             //更新订单
             orderService.updateById(orders1);
             return ResponseEntity.ok("有订单，正在计算中，支付成功");
         }
         else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("余额不足了");
        }
    }

}

