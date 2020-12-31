package com.example.copy.deepcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sunhu
 * @date 2020/12/30 19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Cloneable, Serializable {

    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Country{ hashcode=" +this.hashCode()+
                ", name='" + name + '\'' +
                '}';
    }
}
