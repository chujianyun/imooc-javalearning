package com.imooc.basic.learn_set;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Cat {

    private Integer id;

    private Integer age;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cat cat = (Cat) o;
       return Objects.equals(id, cat.id) ;
       /*&&
        Objects.equals(age, cat.age) &&
                Objects.equals(name, cat.name)*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
        //return Objects.hash(id, age, name);
    }
}
