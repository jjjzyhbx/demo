package com.Chlin.blog.dao;

import com.Chlin.blog.mapper.UserMapper;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class userDaotest {

    @Autowired
    private     UserMapper userMapper ;
    @Test
   public void testone(){
        UserDao userDao=UserDao.getInstance();
       val users = userDao.selectAll(userMapper);
        users.forEach(System.out::println);
    }
}
