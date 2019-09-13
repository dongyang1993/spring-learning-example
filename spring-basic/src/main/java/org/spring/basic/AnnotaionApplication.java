package org.spring.basic;

import org.spring.basic.bean.HelloWorld;
import org.spring.basic.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotaionApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Config.class);
        applicationContext.refresh();

        HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
        helloWorld.speak();
    }
}
