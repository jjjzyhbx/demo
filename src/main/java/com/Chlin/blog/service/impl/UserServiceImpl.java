package com.Chlin.blog.service.impl;

import com.Chlin.blog.Util.ServiceUtils;
import com.Chlin.blog.dao.UserDao;
import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.UserMapper;
import com.Chlin.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
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

    private UserDao userDao=UserDao.getInstance();
    /**
     * login
     */
    @Override
    public boolean login(UserMapper userMapper, User user){
        // 从数据库查询所有用户
        List<User> users = userDao.selectAll(userMapper);
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
    @Override
    public int register(UserMapper userMapper,User user){
        user.setRegisterTime(new Date());
        user.setLastLoginTime(new Date());
        user.setRealName("student");
        user.setBalance(new BigDecimal(0));
        return userDao.insertUserData(userMapper,user);
    }

    /**
     * 记住密码
     * @param request
     * @param user
     * @return
     */
    @Override
    public User rememberPassword(HttpServletRequest request,User user) {
        Cookie[] cookies=request.getCookies();
        String id = null;
        String password = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("password")) {
                    password= cookie.getValue();
//                    System.out.println("impl"+"id" +"/"+password);
                }
            }
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("id")) {
                    id=cookie.getValue();
//                    System.out.println("impl"+"id" +"/"+id);
                }
//                System.out.println("impl"+"id" +"/"+user.getStudentId());
//                if(id!=null&&id.equals(user.getStudentId())){
//                    user.setPassword(password);
////                    System.out.println("impl"+":"+user.toString());
//                    user.setRememberPassword(true);
//                }
                user.setPassword(password);
            }
        }
     }
        return user;
    }


    /**
     * 更新个人信息
     * @param userMapper
     * @param user
     * @return
     */
    @Override
    public int upUserMassage(UserMapper userMapper, User user) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        //更新后台时间
        user.setLastLoginTime(new Date());
        // 存储登录用户信息到会话
         User onlineUsers = (User)session.getAttribute("onlineUsers");
        /**
         * 我打对比onlineUsers跟user不同的地方，然后将user与onlineUsers不同的地方更新到onlineUsers中，然后写入ssession，怎么办
         */

//        final val instance = ServiceUtils.getInstance();
        try {
            user=(User)ServiceUtils.copyChangedFields(onlineUsers,user);
            session.setAttribute("onlineUsers",user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userDao.upDataUserMassageById(userMapper,user);
    }

    public int upUserBalance(UserMapper userMapper, User user) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        //更新后台时间
        user.setLastLoginTime(new Date());
        // 存储登录用户信息到会话
        User onlineUsers = (User)session.getAttribute("onlineUsers");
        /**
         * 我打对比onlineUsers跟user不同的地方，然后将user与onlineUsers不同的地方更新到onlineUsers中，然后写入ssession，怎么办
         */
        BigDecimal sum = onlineUsers.getBalance().add(user.getBalance());
//        final val instance = ServiceUtils.getInstance();
       onlineUsers.setBalance(sum);
        System.out.println("修改后的余额"+onlineUsers.toString());
        return userDao.upDataUserMassageById(userMapper,user);


    }
}
