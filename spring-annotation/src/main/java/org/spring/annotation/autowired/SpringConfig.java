package org.spring.annotation.autowired;

import org.spring.common.bean.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"org.spring.annotation.autowired"})
@Configuration
public class SpringConfig {

    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMsg("Autowried");
        return helloWorld;
    }
}
