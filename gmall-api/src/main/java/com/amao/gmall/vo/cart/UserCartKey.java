package com.amao.gmall.vo.cart;

import lombok.Data;

/**
 * @author amao
 * @date 2020/3/25 22:48
 */
@Data
public class UserCartKey {

    private boolean login; //用户是否登录

    private Long userId; //用户如果登录，id

    private String tempCartKey;  //用户没有登录而且没有购物车的临时购物车key

    private String finalCartKey; //用户最终用那个key

}
