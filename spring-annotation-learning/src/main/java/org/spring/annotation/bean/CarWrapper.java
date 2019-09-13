package org.spring.annotation.bean;

public class CarWrapper {
    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    public void run() {
        this.car.run();
    }
}
