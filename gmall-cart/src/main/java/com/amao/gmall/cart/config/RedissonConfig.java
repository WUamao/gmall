package com.amao.gmall.cart.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author amao
 * @date 2020/3/20 12:12
 */
@Configuration
public class RedissonConfig {

    @Bean
    RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://129.211.77.216:6379");
        return Redisson.create(config);
    }

}
