package com.Chlin.blog.dao;

import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 用户跟数据库交互层crud
 */
public class UserDao {

    private UserDao() {

    }

    public static UserDao getInstance() {
        return new UserDao();
    }

    /**
     * 查找所有
     * @param
     * @return
     */
    public List<User> selectAll(UserMapper userMapper){
        List<User> users = userMapper.selectList(null);
        return users;
    }

    /**
     * 新增
     * @param userMapper
     * @param user
     * @return
     */
    public int insertUserData(UserMapper userMapper,User user){
        return userMapper.insert(user);
    }
    /**
     * 根据id更新
     */
    public int upDataUserMassageById(UserMapper userMapper,User user){
        return userMapper.updateById(user);
    }

    /**
     * 根据id删除
     */
    public int deleteUserMassageById(UserMapper userMapper,User user){
        return userMapper.deleteById(user);
    }
}
