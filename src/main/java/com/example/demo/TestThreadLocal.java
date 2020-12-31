package com.example.demo;

/**
 * @author sunhu
 * @date 2020/9/23 19:17
 */
public class TestThreadLocal {

    static class ThreadA implements Runnable{

        private ThreadLocal threadLocal;

        ThreadA(ThreadLocal threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A输出"+threadLocal.get());
        }
    }


    static class ThreadB implements Runnable{

        private ThreadLocal threadLocal;

        ThreadB(ThreadLocal threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B输出"+threadLocal.get());
        }
    }


    public static void main(String[] args) {
        ThreadLocal threadLocal=new ThreadLocal();
        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();

    }
}
