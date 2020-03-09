package com.amao.gmall.oms.service.impl;

import com.amao.gmall.oms.entity.Order;
import com.amao.gmall.oms.mapper.OrderMapper;
import com.amao.gmall.oms.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
