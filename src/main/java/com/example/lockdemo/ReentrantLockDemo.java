package com.example.lockdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunhu
 * @date 2020/11/25 18:35
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        int[] oldArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index=3;
        int numMoved=oldArr.length-index-1;
        System.arraycopy(oldArr,index+1,oldArr,index,numMoved);
        int[] newArr=new int[9];
        System.arraycopy(oldArr,0,newArr,0,oldArr.length-1);
        System.out.println(Arrays.toString(newArr));
    }

}
