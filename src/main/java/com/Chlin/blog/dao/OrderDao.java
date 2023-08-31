package com.Chlin.blog.dao;

import com.Chlin.blog.entity.Order;
import com.Chlin.blog.mapper.OrderMapper;
import java.util.List;

/**
 * 订单的dao层
 */
public class OrderDao {
    /**
     * 私有构造
     */
    private OrderDao() {
    }

    public static OrderDao getInstance() {
        return new OrderDao();
    }

    /**
     * 基本crud
     */

    /**
     * 查找所有
     * @param
     * @return
     */
    public List<Order> selectAll(OrderMapper orderMapper){
        List<Order> orders =orderMapper.selectList(null);
        return orders;
    }

    /**
     * 新增
     * @param orderMapper
     * @param order
     * @return
     */
    public int insertOrderData(OrderMapper orderMapper, Order order){
        return orderMapper.insert(order);
    }
    /**
     * 根据id更新
     */
    public int upDataUserMassageById(OrderMapper orderMapper,Order order){
        return orderMapper.updateById(order);
    }

    /**
     * 根据id删除
     */
    public int deleteUserMassageById(OrderMapper orderMapperr,Order order){
        return orderMapperr.deleteById(order);
    }
}
