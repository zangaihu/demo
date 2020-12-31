package com.example.annotation;

import java.lang.annotation.*;

/**
 * @author sunhu
 * @date 2020/12/29 11:50
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CarInfo {

    String name() default "";
    int age() default 0;
}
