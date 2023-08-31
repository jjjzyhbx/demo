package com.Chlin.blog.mapper;

import com.Chlin.blog.entity.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@Repository
//@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}
