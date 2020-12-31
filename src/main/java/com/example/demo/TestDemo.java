package com.example.demo;

/**
 * @author sunhu
 * @date 2020/10/9 11:05
 */
public class TestDemo {

    public static void main(String[] args) {
        Integer num1 = 10;
        Integer num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}
