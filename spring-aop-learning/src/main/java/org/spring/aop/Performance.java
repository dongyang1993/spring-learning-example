package org.spring.aop;

@FunctionalInterface
public interface Performance {
    void perform();

    default void performArgs(int name) {
        System.out.println("PerformanceWithName:" + name);
    }

    @MineLog
    default void performAnnotation() {
        System.out.println("performanceWithAnnotation");
    }
}
