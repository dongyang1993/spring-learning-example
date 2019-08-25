package org.spring.basic.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloworld = applicationContext.getBean("helloworld", HelloWorld.class);
        helloworld.speak();
    }
}
