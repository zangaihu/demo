package com.example.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author sunhu
 * @date 2020/12/18 14:01
 */
public class PersonTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class clazz=Person.class;
//        Person p=new Person();

        Class aClass = ClassLoader.getSystemClassLoader().loadClass("com.example.reflect.Person");
        Method[] declaredMethods = aClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.toString());
        }

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.toString());
        }
    }
}
