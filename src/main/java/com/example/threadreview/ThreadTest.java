package com.example.threadreview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author sunhu
 * @date 2020/10/28 18:38
 *
 * 继承Thread(Thread其实实现了Runnable接口 ) 实现Runnable，实现Callable，线程池
 *
 */
public class ThreadTest {

    /**
     * 继承Thread类 ，重写run
     */
    static class MyThread1 extends Thread{
        @Override
        public void run(){
            System.out.println("MyThread1....");
        }
    }

    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThread2....");
        }
    }

    static class MyThread3 implements Callable{

        @Override
        public Object call() throws Exception {
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        MyThread1 myThread1=new MyThread1();
        myThread1.start();

        // 其实是传入Runnable target，Thread会调用target.run
        MyThread2 myThread2=new MyThread2();
        Thread thread=new Thread(myThread2);
        thread.start();





    }
}
