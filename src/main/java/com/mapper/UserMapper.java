package com.mapper;

import com.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
//表示是dao层
public interface UserMapper extends BaseMapper<User> {
}
