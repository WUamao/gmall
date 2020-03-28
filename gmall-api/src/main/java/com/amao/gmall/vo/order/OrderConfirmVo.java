package com.amao.gmall.vo.order;

import com.amao.gmall.sms.entity.Coupon;
import com.amao.gmall.ums.entity.MemberReceiveAddress;
import com.amao.gmall.vo.cart.CartItem;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author amao
 * @date 2020/3/28 11:30
 */
@Data
@ToString
public class OrderConfirmVo implements Serializable {

    List<CartItem> items;//购物项
    List<MemberReceiveAddress> addresses;//收获地址
    List<Coupon> coupons;//优惠卷
    //其他的支付、配送方式
    private String orderToken;  //订单令牌，这个令牌保存好，下一步提交订单必须带上

    private BigDecimal productTotalPrice = new BigDecimal("0");//商品总额
    private BigDecimal totalPrice = new BigDecimal("0");//订单总额
    private Integer count = 0;//商品总数
    private BigDecimal couponPrice = new BigDecimal("0");//优惠卷减免
    private BigDecimal transPrice = new BigDecimal("6"); //运费

}
