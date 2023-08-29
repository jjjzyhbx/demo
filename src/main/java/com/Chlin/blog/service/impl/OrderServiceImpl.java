package com.Chlin.blog.service.impl;

import com.Chlin.blog.entity.Order;
import com.Chlin.blog.mapper.OrderMapper;
import com.Chlin.blog.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
