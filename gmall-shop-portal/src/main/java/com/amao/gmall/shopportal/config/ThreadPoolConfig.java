package com.amao.gmall.shopportal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 配置当前系统的线程信息
 * @author amao
 * @date 2020/3/23 23:47
 */
@Configuration
public class ThreadPoolConfig {


//    @Value("${gmall.pool.coreSize}")
//    private Integer coreSize;
//    @Value("${gmall.pool.maximumPoolSize}")
//    private Integer maximumPoolSize;
//    @Value("${gmall.pool.queueSize}")
//    private Integer queueSize;

    @Bean("mainThreadPoolExecutor")
    public ThreadPoolExecutor mainThreadPoolExecutor(PoolProperties poolProperties){
        /**
         *   public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               RejectedExecutionHandler handler) {
         */
        LinkedBlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(poolProperties.getQueueSize());

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(poolProperties.getCoreSize(),
                poolProperties.getMaximumPoolSize(),
                10, TimeUnit.MINUTES,
                deque);
        return poolExecutor;
    }

    @Bean("otherThreadPoolExecutor")
    public ThreadPoolExecutor otherThreadPoolExecutor(PoolProperties poolProperties){
        LinkedBlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(poolProperties.getQueueSize());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(poolProperties.getCoreSize(),
                poolProperties.getMaximumPoolSize(), 10,
                TimeUnit.MINUTES, deque);

        return threadPoolExecutor;
    }


}
