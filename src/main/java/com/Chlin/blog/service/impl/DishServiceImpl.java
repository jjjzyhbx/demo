package com.Chlin.blog.service.impl;

import com.Chlin.blog.dao.DishDao;
import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.mapper.DishMapper;
import com.Chlin.blog.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    DishDao dishDao=DishDao.getInstance();

    private DishMapper dishMapper;

    public void setDishMapper(DishMapper dishMapper) {
        this.dishMapper = dishMapper;
    }

    @Override
    public int insertNewDish(Dish dish) {
        dish.setCreateTime(new Date());
        dish.setUpdateTime(new Date());
       return dishDao.insertDishData(dishMapper,dish);
    }
}
