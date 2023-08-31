package com.Chlin.blog.service;

import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
public interface UserService extends IService<User> {
    boolean login(UserMapper userMapper, User user);
     int register(UserMapper userMapper,User user);
     User rememberPassword(HttpServletRequest request,User user);
     int upUserMassage(UserMapper userMapper,User user);
}
