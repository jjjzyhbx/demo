package com;


import com.mapper.UserMapper;
import com.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class demo {


    @Autowired
    private UserMapper userMapper;


//查
    @Test
    public void di(){
        System.out.println("get");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        System.out.println("kkk");
    }
    //插入
    @Test
   public void testInsert()
    {
        User user=new User();
        user.setUserid(12);
        user.setUsername("xiaoming");
        user.setPassword("123456789");
        user.setName("xiao");
        user.setEmail("2605527@qq.com");
        user.setRegistrationdate(new Date());
        int result=userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }
    //更新
    @Test
    public void updata(){
        User user=new User();
        user.setUserid(123456);
        user.setPassword("18224978448");
        user.setPhone("110");
        int i=userMapper.updateById(user);
        System.out.println(i);
    }
    @Test
   public void dete(){
        User user=new User();
        user.setUserid(1234567);
        userMapper.deleteById(user);
    }
}
