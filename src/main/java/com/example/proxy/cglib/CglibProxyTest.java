package com.example.proxy.cglib;

import com.example.proxy.UserApi;

/**
 * @author sunhu
 * @date 2020/12/14 19:17
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy=new CglibProxy();
        UserApi userApi = (UserApi) cglibProxy.newInstall(new UserApi());
        String s = userApi.queryUserInfo();
        System.out.println(s);
    }
}
