package com.amao.gmall.oms.service.impl;

import com.amao.gmall.oms.entity.OrderItem;
import com.amao.gmall.oms.mapper.OrderItemMapper;
import com.amao.gmall.oms.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
