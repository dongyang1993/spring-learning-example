package org.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"org.spring.aop"})
@Configuration
public class Config {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public Performance performance() {
        return () -> System.out.println("perform");
    }

    @Bean
    public PerformanceImpl performanceImpl() {
        return new PerformanceImpl();
    }
}
