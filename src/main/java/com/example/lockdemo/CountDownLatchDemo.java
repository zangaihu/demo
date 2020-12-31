package com.example.lockdemo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * CountDownLatch 组队，人齐，一波带走
 *
 * @author sunhu
 * @date 2020/12/14 10:16
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    int millis = new Random().nextInt(10000);
                    System.out.println("等待游客上船，耗时：" + millis + "(millis)");
                    Thread.sleep(millis);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        System.out.println("船长急躁了，开船!");
        // 关闭线程池
        executorService.shutdown();

    }

}
