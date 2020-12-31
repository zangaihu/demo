package com.example.annotation;

/**
 * @author sunhu
 * @date 2020/12/29 11:51
 */
public class Audi {

    @CarInfo(name = "奥迪",age = 123)
    public String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
