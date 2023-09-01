package com.Chlin.blog.dao;

import com.Chlin.blog.entity.Orders;
import com.Chlin.blog.mapper.OrdersMapper;
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
    public List<Orders> selectAll(OrdersMapper ordersMapper){
        List<Orders> orders = ordersMapper.selectList(null);
        return orders;
    }

    /**
     * 新增
     * @param ordersMapper
     * @param orders
     * @return
     */
    public int insertOrderData(OrdersMapper ordersMapper, Orders orders){
        return ordersMapper.insert(orders);
    }
    /**
     * 根据id更新
     */
    public int upDataUserMassageById(OrdersMapper ordersMapper, Orders orders){
        return ordersMapper.updateById(orders);
    }

    /**
     * 根据id删除
     */
    public int deleteUserMassageById(OrdersMapper ordersMapperr, Orders orders){
        return ordersMapperr.deleteById(orders);
    }
}
