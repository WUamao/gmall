package com.amao.gmall.vo.order;

import com.amao.gmall.vo.cart.CartItem;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 结算页需要的ordervo数据
 */
@ToString
@Data
public class OrderCreateVo implements Serializable {

    private String orderSn;//订单号
    private BigDecimal totalPrice;//订单总额

    private Long addressId;//用户的收货地址
    private String detailInfo;//详情描述

    private Long memberId;//会员的id
    private List<CartItem> cartItems;//购买的商品

    private Boolean limit;//限制；验证价格成功才能支付
    private String tokenError;//令牌是否正确；


}

