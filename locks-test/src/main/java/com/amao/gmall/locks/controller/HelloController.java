package com.amao.gmall.locks.controller;

import com.amao.gmall.locks.service.RedisIncrService;
import com.amao.gmall.locks.service.ZkLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Autowired
    RedisIncrService redisIncrService;

    @Autowired
    ZkLockService zkLockService;

    @GetMapping("/incr")
    public String incr(){

        redisIncrService.incr();
        return "ok";
    }

    @GetMapping("/incr2")
    public String incr2(){
        redisIncrService.incrDistribute();
        //System.out.println("8080");
        return "ok";
    }

    @GetMapping("/incr3")
    public String incr3(){
        redisIncrService.useRedissonForLock();
        return "ok";
    }

    @GetMapping("/incr4")
    public String incr4(){
        zkLockService.useZkClientForLock();
        return "ok";
    }
}
