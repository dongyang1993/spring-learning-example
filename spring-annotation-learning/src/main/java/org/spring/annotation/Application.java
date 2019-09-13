package org.spring.annotation;

import org.spring.annotation.bean.HelloWorld;
import org.spring.annotation.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {

    private static HelloWorld helloWorld;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();

        helloWorld.speak();
    }

    @Autowired
    public void setHelloWorld(HelloWorld helloWorld) {
        Application.helloWorld = helloWorld;
    }
}
