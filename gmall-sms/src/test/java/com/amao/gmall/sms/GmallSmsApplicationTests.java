package com.amao.gmall.sms;

import com.amao.gmall.sms.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallSmsApplicationTests {

    @Autowired
    CouponService couponService;

    @Test
    public void contextLoads() {
        System.out.println(couponService.getById(2));
        log.info(couponService.getById(2).toString());
    }

}
