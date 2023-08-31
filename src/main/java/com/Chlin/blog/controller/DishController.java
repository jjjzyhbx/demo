package com.Chlin.blog.controller;


import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.mapper.DishMapper;
import com.Chlin.blog.service.DishService;
import com.Chlin.blog.service.impl.DishServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

//    @Autowired
//    private DishMapper dishMapper;
    private DishService dishService=new DishServiceImpl();
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
        int i=0;
        if (i!=0) {
            return ResponseEntity.ok("修改成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("修改失败");
        }
    }
}

