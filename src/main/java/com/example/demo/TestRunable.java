package com.example.demo;

import java.util.concurrent.*;

/**
 * @author sunhu
 * @date 2020/9/22 14:45
 */
public class TestRunable {

    static class MyThread implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("call...");
            return 2;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        MyThread myThread=new MyThread();
        Future future = executorService.submit(myThread);
        System.out.println(future.get());
    }

}
