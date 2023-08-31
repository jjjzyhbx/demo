package com.Chlin;

import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.DishMapper;
import com.Chlin.blog.mapper.UserMapper;
import com.Chlin.blog.service.impl.DishServiceImpl;
import com.Chlin.blog.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    private UserMapper userMapper;
   private UserServiceImpl userService=new UserServiceImpl();
    @Test
    public void testRegister(){

        User user=new User();
        user.setId(1110);
        user.setUsername("xiao");
        user.setPassword("00000000");
        user.setRealName("Joh");
        user.setType(0);
        user.setStudentId("00000000");
        user.setEmail("E1234560");
        user.setPhone(2);
        user.setGrade(10);
        user.setBalance(new BigDecimal("1000.00"));
        user.setRegisterTime(new Date());
        user.setLastLoginTime(new Date());
        System.out.println(userService.register(userMapper,user));
    }
    @Autowired
    public DishServiceImpl dishService;
    @Test
    public void testDishINsert(){
        Dish dish=new Dish();
        dish.setName("酸汤鱼");
        dish.setInventory(10);
        dish.setPrice(new BigDecimal(10));
        dishService.save(dish);

    }
    @Test
    public void testList(){
        Dish dish=new Dish();
        dish.setName("酸汤鱼");
        dish.setPrice(new BigDecimal(16));
//        dishService.listByEntity(dish).forEach(System.out::println);
        dish.setId(1);
        dishService.updateById(dish);
    }

    @Test
    public void testSele(){

    }
}
