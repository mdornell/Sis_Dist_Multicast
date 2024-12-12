package models;

import java.io.Serializable;

public class Patient implements Serializable {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
