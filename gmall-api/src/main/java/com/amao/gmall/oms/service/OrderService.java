package com.amao.gmall.oms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.amao.gmall.oms.entity.Order;
import com.amao.gmall.vo.order.OrderConfirmVo;
import com.amao.gmall.vo.order.OrderCreateVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
@Component
public interface OrderService extends IService<Order> {

    /**
     * 订单确认
     * @param id
     * @return
     */
    OrderConfirmVo orderConfirm(Long id);


    OrderCreateVo createOrder(BigDecimal frontTotalPrice, Long addressId, String note);

    String pay(String orderSn, String accessToken);

    /**
     * 解析最终的支付结果
     * @param params
     * @return
     */
    String resolvePayResult(Map<String, String> params);
}
