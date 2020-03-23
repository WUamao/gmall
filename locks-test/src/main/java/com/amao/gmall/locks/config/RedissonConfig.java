package com.amao.gmall.locks.config;

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

//    @Bean
//    RedissonClient redisson() {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://120.78.213.182:6379");
//        return Redisson.create(config);
//    }

}
