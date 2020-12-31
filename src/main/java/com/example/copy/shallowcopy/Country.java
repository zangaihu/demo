package com.example.copy.shallowcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author sunhu
 * @date 2020/12/30 19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private String name;

    @Override
    public String toString() {
        return "Country{ hashcode=" +this.hashCode()+
                ", name='" + name + '\'' +
                '}';
    }
}
