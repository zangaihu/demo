package com.example.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sunhu
 * @date 2020/12/14 19:13
 */
public class CglibProxy implements MethodInterceptor {


    public Object newInstall(Object object){
        return Enhancer.create(object.getClass(),this);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我被cglib代理了");
        return methodProxy.invokeSuper(o,objects);
    }
}
