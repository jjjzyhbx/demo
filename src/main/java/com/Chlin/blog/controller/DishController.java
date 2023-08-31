package com.Chlin.blog.controller;


import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.mapper.DishMapper;
import com.Chlin.blog.service.DishService;
import com.Chlin.blog.service.impl.DishServiceImpl;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("这个是dish"+dish.toString());
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
        System.out.println(list.toString());
        return gson.toJson(list);
    }

    @PostMapping("/search")
    public String search(@RequestBody String jsonData){

        Dish dish=gson.fromJson(jsonData,Dish.class);
        List<Dish> dishes = dishService.listByEntity(dish);
        dishes.forEach(System.out::println);
        return gson.toJson(dishes);
    }
}

