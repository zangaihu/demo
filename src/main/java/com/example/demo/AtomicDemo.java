package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author sunhu
 * @date 2020/11/26 14:37
 */
public class AtomicDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger);
    }
}
