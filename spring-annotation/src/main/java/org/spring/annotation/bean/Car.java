package org.spring.annotation.bean;

import org.springframework.stereotype.Component;

@Component("carc")
public class Car {

    private String name = "car";

    public void run() {
        System.out.println(name + " is running");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
