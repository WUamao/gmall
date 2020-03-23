package com.amao.gmall.locks.config;


import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @author amao
 * @date 2020/3/21 0:18
 */
public class ZkClientLock implements ZkLock {

    public static final String ZKSERVER = "129.211.77.216:2181";
    public static final int TIME_OUT = 100 * 1000;
    public static String path = "/GmallLock";

    ZkClient zkClient = new ZkClient(ZKSERVER,TIME_OUT);

    protected CountDownLatch countDownLatch = null;

    @Override
    public void zklock() {

        if(tryZklock()){
            System.out.println(Thread.currentThread().getName()+ "\t" + "加锁成功");
        }else {
            waitZklock();
            zklock();
        }
    }

    @Override
    public void zkUnlock() {
        if (zkClient != null){
            zkClient.close();
        }
        System.out.println(Thread.currentThread().getName()+ "\t" + "解锁成功");

        System.out.println();
        System.out.println();
    }

    private boolean tryZklock() {
        try {
            //zkClient.create(ZkClientConfig.path,null,null, CreateMode.EPHEMERAL);
            zkClient.createEphemeral(path);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    private void waitZklock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null){
                    countDownLatch.countDown();
                }
            }
        };
        zkClient.subscribeDataChanges(path,iZkDataListener);
        if (zkClient.exists(path)){
            //只能等着，不能往下走
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(path,iZkDataListener);

    }

}
