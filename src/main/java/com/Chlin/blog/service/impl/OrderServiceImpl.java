package com.Chlin.blog.service.impl;

import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.entity.Orders;
import com.Chlin.blog.entity.User;
import com.Chlin.blog.mapper.OrdersMapper;
import com.Chlin.blog.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

/**
 * 订单服务，
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrderService {

   private Orders orders =new Orders();


    @Override
    public void setOrder(Orders order) {
        orders=order;
    }

    public Orders getOrders() {
        return orders;
    }

    /**
     * crud
     */
    //创建订单


    @Override
    public Orders createOrder(User user, Dish dish) {
        orders.setUserId(user.getId());
        orders.setDishId(dish.getId());
        orders.setAmount(dish.getPrice());
        orders.setCount(1);
        orders.setPaidAmount(dish.getPrice());
        orders.setCreateTime(new Date());
        orders.setPayType(1);
        orders.setStatus(0);
        return orders;
    }

    /**
     * 保存一个订单，更新到数据库中
     * @param entity
     * @return
     */
    @Override
    public boolean save(Orders entity) {
        //加入购物车等于创建订单，支付等于完成订单
        entity.setStatus(0);
        return super.save(entity);
    }

    /**
     * 更新一个订单
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(Orders entity) {
        if(entity.getStatus()!=0){
            entity.setCompleteTime(new Date());
        }
        return super.updateById(entity);
    }

    /**
     * 根据用户id查找他需要的订单
     * @param
     * @return
     */
    public List<Orders> listByUserStudentId(Integer userid) {
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("user_id",userid);
        return super.list(queryWrapper);
    }

    /**
     * 根据用户学号跟订单号删除订单
     * @param
     * @return
     */
    @Override
    public boolean removeByUseridAndDishId(Integer userid,Integer dishId) {
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("user_id",userid);
        queryWrapper.like("dish_id",dishId);
        return super.remove(queryWrapper);
    }


}
