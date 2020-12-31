package com.example.copy.shallowcopy;

import lombok.Data;
import lombok.ToString;

/**
 * @author sunhu
 * @date 2020/12/30 19:32
 */
@Data
public class Car implements Cloneable{
    //基本类型
    private String brand;
    private Integer price;

    private Country country;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
