package com.amao.gmall.locks.config;

/**
 * @author amao
 * @date 2020/3/21 0:17
 */
public interface ZkLock {

    void zklock();

    void zkUnlock();

}
