package com.example.proxy;

import java.lang.reflect.Method;

/**
 * @author sunhu
 * @date 2020/12/14 18:43
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Class clazz=UserApi.class;
        Method queryUserInfo = clazz.getMethod("queryUserInfo");
        Object invoke = queryUserInfo.invoke(clazz.newInstance());
        System.out.println(invoke);
    }
}
