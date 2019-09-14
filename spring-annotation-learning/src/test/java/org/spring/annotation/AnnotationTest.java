package org.spring.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.annotation.bean.Car;
import org.spring.annotation.bean.CarWrapper;
import org.spring.annotation.bean.HelloWorld;
import org.spring.annotation.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AnnotationTest {

    /**
     * @Autowired 注入Bean
     * @Qualifier 可以指定注入BeanId相符的Bean
     */
    @Autowired
    @Qualifier("helloWorld")
    private HelloWorld helloWorld;

    @Autowired
    @Qualifier("helloWorld2M")
    private HelloWorld helloWorld2;

    @Autowired
    private Car car;

    @Autowired
    @Qualifier("carx")
    private Car carz;

    @Autowired
    private CarWrapper carWrapper;

    @Autowired
    private Environment environment;

    @Value("${mine.monday}")
    private String monday;

    @Test
    public void test1() {
        helloWorld.speak();
        helloWorld2.speak();
    }

    @Test
    public void test2() {
        car.run();
    }

    @Test
    public void test3() {
        carWrapper.run();
    }

    @Test
    public void test4() {
        car.run();
        carz.run();
    }

    @Test
    public void test5() {
        System.out.println(monday);
        System.out.println(environment.getProperty("mine.monday"));
    }

    @Test
    public void test6() throws IOException {
        ClassPathResource resource = new ClassPathResource("config.properties");
        InputStream in = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        reader.lines().forEach(System.out::println);
        reader.close();
    }

    @Test
    public void test7() throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        reader.lines().forEach(System.out::println);
        reader.close();
    }
}
