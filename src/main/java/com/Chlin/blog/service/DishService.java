package com.Chlin.blog.service;

import com.Chlin.blog.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
public interface DishService extends IService<Dish> {

    int insertNewDish(Dish dish);

    List<Dish> listByEntity(Dish dish);
    boolean updateBatchByDishList(List<Dish> dishList);


}
