package com.example.annotation;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author sunhu
 * @date 2020/12/29 11:53
 */
public class AnnotationTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        getCarInfo(Audi.class);


        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(dateFormat.format(time));
    }


    public static void   getCarInfo(Class<?> clazz) throws IllegalAccessException, InstantiationException {

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if(declaredField.isAnnotationPresent(CarInfo.class)){

                CarInfo annotation = declaredField.getAnnotation(CarInfo.class);
                System.out.println(annotation.name()+":"+annotation.age());
            }
        }

    }
}
