package org.spring.aop;

public class PerformanceImpl implements Performance {
    @Override
    public void perform() {
        System.out.println("PerformanceImpl");
    }
}
