package com.example.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk代理-代理接口
 *
 * @author sunhu
 * @date 2020/12/14 18:48
 */
public class JDKProxy {

    public static <T> T getProxy(Class clazz){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{clazz}, (proxy, method, args) -> {
            System.out.println(method.getName()+"你被代理了");
            return "有所收获";
        });

    }

}
