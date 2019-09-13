package org.spring.basic;

import org.spring.common.bean.HelloWorld;
import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMsg("Annotation");
        return helloWorld;
    }
}
