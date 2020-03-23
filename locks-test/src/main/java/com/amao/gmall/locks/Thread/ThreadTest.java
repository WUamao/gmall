package com.amao.gmall.locks.Thread;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author amao
 * @date 2020/3/23 21:10
 */
public class ThreadTest {

//    public static void main(String[] args) {
//        System.out.println("主线程......");
//        Thread01 thread01 = new Thread01();
//        //异步化
//        new Thread(thread01).start();
//        new Thread(new Thread02()).start();
//        FutureTask<String> task = new FutureTask<>(new Thread03());
//        new Thread(task).start();
//        //获取异步运行的结果
//        String s = null;
//        try {
//            s = task.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println("异步获取到的结果是: " + s);
//
//        System.out.println("主线程结束......");
//    }
//    public static void main(String[] args) {
//        //使用线程池控制系统资源，防止线程资源耗尽
//        //线程数调多少？cpu内核数。实际：必须通过压力测试来寻找系统最佳参数
//        //压力。峰值流量*3。100,8,9；  16-8   cpu^3
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//
//        //默认的线程池里面的Queue是一个无界队列。
//        //极限情况。线程全部放进队列。无界队列撑爆内存。
//        //ThreadPool：拒绝策略。
//
//        System.out.println("线程池任务准备....");
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() -> {
//                System.out.println("当前线程开始：" + Thread.currentThread().getName());
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                int j = 10/0;
//                System.out.println("当前线程结束:" + Thread.currentThread().getName());
//            });
//            //给线程池提交任务
//            threadPool.submit(thread);
//        }
//        threadPool.shutdown();
//        System.out.println("所有任务都已提交....");
//    }

    /**
     * 任务交给线程池，出现异常无法感知。
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        System.out.println("主线程......");
//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程开始：" + Thread.currentThread());
//            String uuid = UUID.randomUUID().toString();
//            System.out.println("当前线程结束：" + Thread.currentThread());
//            return uuid;
//        }, threadPool).thenApply((res)->{
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            }catch (Exception e){
//            }
//            System.out.println("上一步的结果是: "+res);
//            return res.replace("-","");
//        }).whenCompleteAsync((r,e)->{
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            }catch (Exception e1){
//            }
//            System.out.println("最终结果...."+r);
//        });
//
//        System.out.println("主线程结束......");
//
//        threadPool.shutdown();
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
            System.out.println("查询商品基本数据...");
            return "小米";
        },pool).thenApplyAsync((res)->{
            return res + "  小米10";
        }).whenComplete((r,e)->{
            System.out.println("f1结果是： " + r);
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("查询商品属性数据...");
            return 1;
        }, pool).whenComplete((r,e)->{
            System.out.println("结果是："+r);
        });

        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("查询商品营销数据...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "满199减100";
        }, pool).whenComplete((r,e)->{
            System.out.println("结果是："+r);
        });

        Future<String> future = pool.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "xixixixi";
        });

        System.out.println(future.get());

        //所有人都执行完
        CompletableFuture<Void> allOf = CompletableFuture.allOf(f1, f2, f3);

        //Void aVoid = allOf.get();
        //allOf.join();//线程插队。

        //CompletableFuture<Object> anyOf = CompletableFuture.anyOf(f1, f2, f3);

        System.out.println("所有人都完成了...."+f1.get());


        //以后异步任务的编程模式。。。。。
        //CompletableFuture.supplyAsync(()->{},pool).whenComplete()
    }

}

class Thread01 extends Thread{

    public void run (){
        try {
            System.out.println("Thread01开始运行");
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){

        }
        System.out.println("Thread01-当前线程" + Thread.currentThread().getName());
    }
}

class Thread02 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Thread02开始运行");
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
        }
        System.out.println("Thread02-当前线程" + Thread.currentThread().getName());
    }
}

class Thread03 implements Callable<String>{

    @Override
    public String call() throws Exception {
        try {
            System.out.println("Callable开始运行");
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
        }
        System.out.println("Thread02-当前线程" + Thread.currentThread().getName());
        return "ok";
    }

}
