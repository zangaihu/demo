package com.example.proxy.jdkproxy;

import com.example.proxy.IUserApi;
import com.example.proxy.UserApi;

/**
 * @author sunhu
 * @date 2020/12/14 18:56
 */
public class JDKProxyTest {

    public static void main(String[] args) {
         IUserApi userApi= JDKProxy.getProxy(IUserApi.class);
        String s = userApi.queryUserInfo();
        System.out.println(s);

    }
}
