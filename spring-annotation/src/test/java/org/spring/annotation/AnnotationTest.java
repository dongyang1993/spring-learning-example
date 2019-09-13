package org.spring.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.annotation.bean.HelloWorld;
import org.spring.annotation.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AnnotationTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void test1() {
        helloWorld.speak();
    }

    @Test
    public void test2() {

    }
}
