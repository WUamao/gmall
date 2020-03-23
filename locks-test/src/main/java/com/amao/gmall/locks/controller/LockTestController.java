package com.amao.gmall.locks.controller;

import com.amao.gmall.locks.service.RedissonLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amao
 * @date 2020/3/21 23:54
 */
@RestController
public class LockTestController {


    @Autowired
    RedissonLockService redissonLockService;


    @GetMapping("/lock")
    public Boolean lock(){
        return redissonLockService.lock();
    }

    @GetMapping("/read")
    public String read(){
        return redissonLockService.read();
    }

    @GetMapping("/write")
    public String write(){
        return redissonLockService.write();
    }


    @GetMapping("/rc")
    public Boolean release() throws InterruptedException {


        return redissonLockService.rc();
    }


    @GetMapping("/tc")
    public Boolean park() throws InterruptedException {


        return redissonLockService.tc();
    }

    @GetMapping("/go")
    public Boolean gogogo(){
        return redissonLockService.gogogo();
    }


    @GetMapping("/suomen")
    public String suomen() throws InterruptedException {
        Boolean suomen = redissonLockService.suomen();
        return "锁门了...";
    }


}
