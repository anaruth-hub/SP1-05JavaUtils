package com.ana.javaUtils.level1;
import java.io.Serializable;
public class PersonEx05 implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;

    public PersonEx05(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}
