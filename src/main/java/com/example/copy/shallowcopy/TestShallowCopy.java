package com.example.copy.shallowcopy;

/**
 * 浅拷贝
 * 实现cloneable接口，改变引用类型的数据，会作用到源
 * @author sunhu
 * @date 2020/12/30 19:37
 */
public class TestShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Car a=new Car();
        a.setBrand("audi");
        a.setPrice(300000);
        a.setCountry(new Country("德国"));
        /*
            浅拷贝
        * 实现cloneable接口，改变引用类型的数据，会作用到源
         */
        Car b= (Car) a.clone();
        b.setBrand("honda");
        b.setPrice(100000);
        b.getCountry().setName("日本");

        System.out.println(a.toString());
        System.out.println(b.toString());

        /**
         * 直接复制，只复制了引用，实际指向同一个对象，改变值，会直接作用于源
         */
        Car c=a;
        c.setBrand("KTM");
        c.setPrice(500000);


        System.out.println(a.toString());
        System.out.println(c.toString());


    }
}
