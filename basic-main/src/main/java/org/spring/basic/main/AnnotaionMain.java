package org.spring.basic.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotaionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Config.class);
        applicationContext.refresh();

        HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
        helloWorld.speak();
    }
}
