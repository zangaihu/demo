package com.example.lockdemo;

import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;

import java.util.Collections;
import java.util.concurrent.Semaphore;

/**
 * 信号量的使用，占坑，坑满，等待释放
 *
 * @author sunhu
 * @date 2020/12/14 9:32
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(2, false);
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                try {
                    semaphore.acquireUninterruptibly();
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000L);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"编号"+i).start();
        }

    }
}
