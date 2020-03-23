package com.amao.gmall.locks.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author amao
 * @date 2020/3/19 23:13
 */
@Configuration
public class JedisConfig {


    //Jedis对象不是线程安全的，在多线程下使用同一个Jedis对象会出现并发问题，为了避免每次使用Jedis对象时都需要重新创建，Jedis提供了JedisPool。Jedis是线程安全的连接池
    @Bean
    public JedisPool jedisPoolConfig(RedisProperties properties) throws Exception {
        //1、连接工厂中所有信息都有。
        JedisPoolConfig config = new JedisPoolConfig();

        RedisProperties.Pool pool = properties.getJedis().getPool();


        //这些配置
        config.setMaxIdle(pool.getMaxIdle());
        config.setMaxTotal(pool.getMaxActive());

        JedisPool jedisPool = null;
        jedisPool = new JedisPool(config, properties.getHost(), properties.getPort());


        return jedisPool;
    }
}
