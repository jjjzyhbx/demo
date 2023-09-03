package com.Chlin;

import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.entity.Orders;
import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.DishMapper;
import com.Chlin.blog.mapper.UserMapper;
import com.Chlin.blog.service.OrderService;
import com.Chlin.blog.service.impl.DishServiceImpl;
import com.Chlin.blog.service.impl.OrderServiceImpl;
import com.Chlin.blog.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import lombok.val;
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

    @Autowired
    OrderService orderService=new OrderServiceImpl();
    @Test
    public void testOrder(){

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
        Dish dish=new Dish();
        dish.setName("酸汤鱼");
        dish.setPrice(new BigDecimal(16));
//        dishService.listByEntity(dish).forEach(System.out::println);
        dish.setId(1);
         val order = orderService.createOrder(user, dish);
         order.setId(2);
         orderService.save(order);
//        final val dish1 = dishService.listByEntityID(dish);
//        final val byId = dishService.getById(dish.getId());
//        System.out.println(byId);
//        Orders orders=new Orders();
//        orders.setUserId(2);
//        orders.setDishId(2);
//        final val orders1 = orderService.listByUseridAndDishId(orders);
//        System.out.println(orders1);
//         orderService.save(order);

//        orderService.listByUserStudentId(1).forEach(System.out::println);
//        orderService.removeByUseridAndDishId(1,1);

    }
    Gson gson=new Gson();
    @Test
    public  void jsonTest(){

        String jsonData="{\"name\":\"rstyj\",\"price\":1111,\"updateTime\":\"2023-08-31 22:31:33\",\"monthlySales\":3,\"inventory\":0}";
        Dish dish=gson.fromJson(jsonData,Dish.class);

    }
}
