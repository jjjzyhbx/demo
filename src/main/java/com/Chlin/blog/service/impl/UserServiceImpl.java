package com.Chlin.blog.service.impl;

import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.UserMapper;
import com.Chlin.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

//    @Autowired
//    private UserMapper userMapper;
    /**
     * login
     */
    public boolean login(UserMapper userMapper, User user){

        // 从数据库查询所有用户
        List<User> users = userMapper.selectList(null);

        // 遍历用户列表,查找匹配的用户
        for(User u : users){
            // 判断用户名和密码是否匹配
            if(u.getPassword().equals(user.getPassword())&&u.getStudentId().equals(user.getStudentId())) {
                // 找到匹配用户,登录成功
                // 获取当前请求的上下文
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                HttpSession session = request.getSession();
                // 存储登录用户信息到会话
                session.setAttribute("onlineUsers", u);
                return true;
            }
        }

        // 没找到匹配用户,登录失败
        return false;

    }

    /**
     * register
     * 注册
     */
    public int register(UserMapper userMapper,User user){
        return userMapper.insert(user);
    }


}
