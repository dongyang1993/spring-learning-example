package org.spring.basic;

import org.spring.common.bean.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloworld = applicationContext.getBean("helloworld", HelloWorld.class);
        helloworld.speak();
    }
}
