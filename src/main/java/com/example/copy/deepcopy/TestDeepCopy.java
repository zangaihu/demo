package com.example.copy.deepcopy;

/**
 * 浅拷贝
 * 实现cloneable接口，改变引用类型的数据，会作用到源
 * @author sunhu
 * @date 2020/12/30 19:37
 */
public class TestDeepCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Car a=new Car();
        a.setBrand("audi");
        a.setPrice(300000);
        a.setCountry(new Country("德国"));
        /**
         * 深拷贝，引用类型的属性，也要实现cloneable，层层对象都需要
         * 相当于给引用属性开辟独立空间
         */
        Car b= (Car) a.clone();
        b.setBrand("honda");
        b.setPrice(100000);
        b.getCountry().setName("日本");

        System.out.println("a  "+a.toString());
        System.out.println("b  "+b.toString());


        Car d=CloneUtil.clone(a);
        d.getCountry().setName("USA");
        System.out.println("a  "  +a.toString());
        System.out.println("d  " +d.toString());


    }
}
