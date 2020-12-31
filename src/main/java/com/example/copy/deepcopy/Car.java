package com.example.copy.deepcopy;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sunhu
 * @date 2020/12/30 19:32
 */
@Data
public class Car implements Cloneable, Serializable {
    //基本类型
    private String brand;
    private Integer price;

    private Country country;


    @Override
    public Object clone() throws CloneNotSupportedException {

        Car car = (Car) super.clone();
        car.country= (Country) country.clone();
        return car;
    }

    @Override
    public String toString() {
        return "Car{ hashcode=" +this.hashCode()+
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", country=" + country +
                '}';
    }
}
