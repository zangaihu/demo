package com.example.thread;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunhu
 * @date 2020/11/25 19:12
 */
public class ThreadLocalDemo implements Runnable{

    private static final ThreadLocal<SimpleDateFormat> formatter=ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo obj =new ThreadLocalDemo();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
/*        AtomicInteger atomicInteger1=new AtomicInteger(2);
        atomicInteger1.incrementAndGet();
        System.out.println(atomicInteger1);
        AtomicInteger atomicInteger2=new AtomicInteger(2);
        atomicInteger2.getAndIncrement();
        System.out.println(atomicInteger2);*/
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat("EEEE, dd MMMM yyyy"));

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }
}
