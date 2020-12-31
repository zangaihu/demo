package com.example.demo;

/**
 * @author sunhu
 * @date 2020/11/23 19:37
 */
public class Singleton {

    private volatile  static  Singleton instance;

    private Singleton(){}

    public Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
