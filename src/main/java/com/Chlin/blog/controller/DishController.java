package com.Chlin.blog.controller;


import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.entity.Orders;
import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.DishMapper;
import com.Chlin.blog.service.DishService;
import com.Chlin.blog.service.OrderService;
import com.Chlin.blog.service.impl.DishServiceImpl;
import com.Chlin.blog.service.impl.OrderServiceImpl;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *菜品控制器
 * @author Chlin
 * @since 2023-08-29
 */
@RestController
@RequestMapping("/blog/dish")
public class DishController {
    private Gson gson = new Gson();

    @Autowired
    public DishService dishService;
    /**
     * 新增一个菜
     * @param jsonData
     * @return
     */
    @PostMapping("/newDish")
    public ResponseEntity<String> newDish(@RequestBody String jsonData){
        Dish dish=new Dish();
        dish=gson.fromJson(jsonData,Dish.class);
        final val i = dishService.save(dish);
        if (i) {
            return ResponseEntity.ok("添加成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加失败");
        }
    }
    @PostMapping("/loadDish")
    public String loadDish(){
        List<Dish> list = dishService.list();
        return gson.toJson(list);
    }

    @PostMapping("/search")
    public String search(@RequestBody String jsonData){

        Dish dish=gson.fromJson(jsonData,Dish.class);
        List<Dish> dishes = dishService.listByEntity(dish);
        return gson.toJson(dishes);
    }
    @Autowired
    OrderService orderService=new OrderServiceImpl();
    /**
     * 添加到购物车操作
     * 1.返回当前的选中的菜，
     * 2.获取当前在线操作的用户
     * 3.创造一个订单
     * @param jsonData
     * @param
     * @return
     */
    @PostMapping("/addShop")
    public ResponseEntity<String> addShopping(@RequestBody String jsonData,HttpServletRequest request){
        //获得在线用户
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
        HttpSession session=request.getSession();
        val onlineUsers = (User)session.getAttribute("onlineUsers");

        //获得返回的数据，通过dishid查询是否拥有
        Dish dish=gson.fromJson(jsonData,Dish.class);
         val dishes = dishService.getById(dish.getId());
         //根据用户和dish，创建一个订单
        val order = orderService.createOrder(onlineUsers, dishes);
        //将订单保存到数据库中
        val save = orderService.save(order);
        if (save) {
            return ResponseEntity.ok("添加成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加失败");
        }
    }

    @PostMapping("/myDish")
    public String loadMyDish(HttpServletRequest request){

        HttpSession session=request.getSession();
        val onlineUsers = (User)session.getAttribute("onlineUsers");
        //获得当前用户订单
        val orders = orderService.listByUserStudentId(onlineUsers.getId());

        List<Integer> list =new ArrayList<>();
        for (Orders orders1: orders
             ) {
            list.add(orders1.getDishId());
        }
        //根据订单获得菜品
       val dishes = dishService.listByIds(list);
        return gson.toJson(dishes);
    }
}

