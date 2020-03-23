package com.amao.gmall.shopportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author amao
 * @date 2020/3/23 23:57
 */
@RestController
public class ThreadPoolController {

    @Autowired
    ThreadPoolExecutor mainThreadPoolExecutor;

    @Autowired
    ThreadPoolExecutor otherThreadPoolExecutor;

    @GetMapping("/thread/status")
    public Map threadPoolStatue(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> mainMap = new HashMap<>();
        Map<String,Object> otherMap = new HashMap<>();

        mainMap.put("ActiveCount",mainThreadPoolExecutor.getActiveCount());
        mainMap.put("CorePoolSize",mainThreadPoolExecutor.getCorePoolSize());

        otherMap.put("ActiveCount",otherThreadPoolExecutor.getActiveCount());
        otherMap.put("CorePoolSize",otherThreadPoolExecutor.getCorePoolSize());
        RejectedExecutionHandler handler = otherThreadPoolExecutor.getRejectedExecutionHandler();
        otherMap.put("RejectedExecutionHandler",handler.toString());
        otherMap.put("CompletedTaskCount",otherThreadPoolExecutor.getCompletedTaskCount());

        map.put("main",mainMap);
        map.put("other",otherMap);

        return map;
    }

}
