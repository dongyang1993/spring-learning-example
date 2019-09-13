package org.spring.annotation.autowired;

import org.spring.common.bean.HelloWorld;
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
