package com.amao.gmall.vo.cart;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author amao
 * @date 2020/3/25 21:27
 */
@Setter
public class Cart implements Serializable {

    @Getter
    List<CartItem> cartItems;//所有的购物项

    private Integer count; //商品总数

    private BigDecimal totalPrice; //已选中商品的总数


    private Integer checkCount; //商品总数

    private BigDecimal checkTotalPrice; //已选中商品的总数


    //购物车数据返回给前端
    public Integer getCount(){
        AtomicInteger atomic = new AtomicInteger(0);
        if (cartItems != null){
            cartItems.forEach((cartItem)->{
                atomic.getAndAdd(cartItem.getCount());
            });
            return atomic.get();
        }else {
            return 0;
        }
    }

    public BigDecimal getTotalPrice(){
        if (cartItems != null){
            AtomicReference<BigDecimal> allTotal = new AtomicReference<>(new BigDecimal("0"));
            cartItems.forEach((cartItem)->{
                BigDecimal add = allTotal.get().add(cartItem.getTotalPrice());
                allTotal.set(add);
            });
            return allTotal.get();
        }else {
            return new BigDecimal("0");
        }
    }

    //购物车数据返回给前端
    public Integer getCheckCount(){
        AtomicInteger atomic = new AtomicInteger(0);
        if (cartItems != null){
            cartItems.forEach((cartItem)->{
                if (cartItem.isCheck()){
                    atomic.getAndAdd(cartItem.getCount());
                }
            });
            return atomic.get();
        }else {
            return 0;
        }
    }

    public BigDecimal getCheckTotalPrice(){
        if (cartItems != null){
            AtomicReference<BigDecimal> allTotal = new AtomicReference<>(new BigDecimal("0"));
            cartItems.forEach((cartItem)->{
                if (cartItem.isCheck()){
                    BigDecimal add = allTotal.get().add(cartItem.getTotalPrice());
                    allTotal.set(add);
                }
            });
            return allTotal.get();
        }else {
            return new BigDecimal("0");
        }
    }




}
