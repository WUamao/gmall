package com.amao.gmall.cart;

import com.amao.gmall.vo.cart.Cart;
import com.amao.gmall.vo.cart.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest(classes = GmallCartApplication.class)
class GmallCartApplicationTests {

    @Test
    void contextLoads() {

        CartItem cartItem = new CartItem();
        cartItem.setCount(2);
        cartItem.setPrice(new BigDecimal("10.98"));


        CartItem cartItem2 = new CartItem();
        cartItem2.setCount(1);
        cartItem2.setPrice(new BigDecimal("11.3"));

        System.out.println("==>"+cartItem.getPrice());
        System.out.println("==>"+cartItem.getTotalPrice());


        Cart cart = new Cart();

        cart.setCartItems(Arrays.asList(cartItem,cartItem2));

        System.out.println(cart.getCount());
        System.out.println(cart.getTotalPrice());

    }

}
