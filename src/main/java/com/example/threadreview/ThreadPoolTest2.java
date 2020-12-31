package com.example.threadreview;

import java.util.concurrent.*;

/**
 * @author sunhu
 * @date 2020/11/26 11:25
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 17; i++) {
            Runnable worker=new MyRunnable(" "+i);
            threadPoolExecutor.execute(worker);
        }
        threadPoolExecutor.shutdown();

        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);

    }
}
