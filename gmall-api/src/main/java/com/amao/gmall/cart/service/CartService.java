package com.amao.gmall.cart.service;

import com.amao.gmall.vo.cart.CartItem;
import com.amao.gmall.vo.cart.CartResponse;

import java.util.List;

/**
 * @author amao
 * @date 2020/3/25 21:04
 */
public interface CartService  {
    /**
     * 添加商品区购物车
     * @param skuId
     * @param cartKey
     * @param accessToken
     * @return
     */
    public CartResponse addToCart(Long skuId, Integer num, String cartKey, String accessToken);

    /**
     * 修改购物项数量
     * @param skuId
     * @param num
     * @param cartKey
     * @param accessToken
     * @return
     */
    CartResponse updateCartItem(Long skuId, Integer num, String cartKey, String accessToken);

    /**
     * 获取购物车的所有数据
     * @param cartKey
     * @param accessToken
     * @return
     */
    CartResponse listCart(String cartKey, String accessToken);

    /**
     * 删除购物项
     * @param skuId
     * @param cartKey
     * @param accessToken
     * @return
     */
    CartResponse delCartItem(Long skuId, String cartKey, String accessToken);

    /**
     * 清空购物车
     * @param cartKey
     * @param accessToken
     * @return
     */
    CartResponse clearCart(String cartKey, String accessToken);

    /**
     * 选中/不选中某些商品
     * @param skuIds
     * @param ops
     * @param cartKey
     * @param accessToken
     * @return
     */
    CartResponse checkCartItems(String skuIds, Integer ops, String cartKey, String accessToken);

    /**
     * 获取某个用户的购物车中选中的商品
     * @param accessToken
     * @return
     */
    List<CartItem> getCartItemForOrder(String accessToken);

    /**
     * 下单后后删除CartItem
     * @param accessToken
     * @param skuIds
     * @return
     */
    void removeCartItem(String accessToken, List<Long> skuIds);
}
