package com.example.keng.nullpoint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sunhu
 * @date 2020/12/31 15:31
 */
public class Test1 {

    public static void main(String[] args) {
/*
        List list=new ArrayList();
        List list1=null;
        //index of bound
        System.out.println(list.get(0));
        //nullpointer
        System.out.println(list1.get(0));
        */
        //d 大写Y，按周计算年，本周跨年，会有问题

//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
