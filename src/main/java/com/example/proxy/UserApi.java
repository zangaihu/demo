package com.example.proxy;

public class UserApi implements IUserApi {

    @Override
    public String queryUserInfo() {
        return "有所收获!";
    }

}