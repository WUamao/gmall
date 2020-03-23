package com.amao.gmall.locks.service;

import com.amao.gmall.locks.config.ZkClientLock;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author amao
 * @date 2020/3/21 19:55
 */
@Service
public class ZkLockService {

    @Autowired
    StringRedisTemplate redisTemplate;



    //20并发10次  单机跑 74 seconds   集群三台服务器 67.481 seconds
    //
    public void useZkClientForLock() {
        ZkClientLock zkClientLock = new ZkClientLock();
        zkClientLock.zklock();
        try {
            String num = redisTemplate.opsForValue().get("num");
            Integer i = Integer.parseInt(num);
            i = i+1;
            redisTemplate.opsForValue().set("num",i.toString());
            System.out.println("释放锁...");

        }finally {
            zkClientLock.zkUnlock();//解锁
        }

    }

}
