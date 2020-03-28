package com.amao.gmall.vo.cart;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author amao
 * @date 2020/3/25 21:26
 */
@Data
@ToString
public class CartResponse implements Serializable {

    private Cart cart; //整个购物车
    private CartItem cartItem; //某项购物项

    private String cartKey;

}
