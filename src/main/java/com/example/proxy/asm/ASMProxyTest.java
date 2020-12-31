package com.example.proxy.asm;

import com.example.proxy.IUserApi;
import com.example.proxy.UserApi;

/**
 * @author sunhu
 * @date 2020/12/14 19:28
 */
public class ASMProxyTest {

    public static void main(String[] args) throws Exception {
        IUserApi userApi = ASMProxy.getProxy(UserApi.class);
        String invoke = userApi.queryUserInfo();
        System.out.println(invoke);
    }

}
