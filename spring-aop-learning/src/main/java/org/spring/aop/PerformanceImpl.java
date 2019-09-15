package org.spring.aop;

public class PerformanceImpl implements Performance {
    @Override
    public void perform() {
        System.out.println("PerformanceImpl");
    }

    @Override
    public void performArgs(int name) {
        System.out.println("PerformanceImplWithName:" + name);
    }
}
