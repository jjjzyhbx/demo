package com.Chlin;

import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.UserMapper;
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
        user.setId(111);
        user.setUsername("xiaoming");
        user.setPassword("password123");
        user.setRealName("John Doe");
        user.setType(0);
        user.setStudentId("123456789");
        user.setEmail("E123456");
        user.setPhone(2);
        user.setGrade(10);
        user.setBalance(new BigDecimal("1000.00"));
        user.setRegisterTime(new Date());
        user.setLastLoginTime(new Date());
        System.out.println(userService.register(userMapper,user));
    }
//    @Test
//    public void testLogin(){
//        userService.login(userMapper);
//    }
}
