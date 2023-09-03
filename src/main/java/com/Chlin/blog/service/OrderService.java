package com.Chlin.blog.service;

import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.entity.Orders;
import com.Chlin.blog.entity.User;
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
public interface OrderService extends IService<Orders> {
    Orders createOrder(User user, Dish dish);

    List<Orders> listByUserStudentId(Integer intger);
    Orders listByUseridAndDishId(Orders orders);

    void setOrder(Orders order);
    boolean removeByUseridAndDishId(Integer userid,Integer dishId);
}
