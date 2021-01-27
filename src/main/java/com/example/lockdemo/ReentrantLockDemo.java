package com.example.lockdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunhu
 * @date 2020/11/25 18:35
 */
public class ReentrantLockDemo {

    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
}
