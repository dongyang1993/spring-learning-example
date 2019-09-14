package org.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class AopTest {

    @Autowired
    private Performance performance;

    /**
     * SpringAOP注入的必须是接口，动态代理的限制
     * 注入实现类则没有用， 不过通过接口注入，bean是实现类，则是可以的。
     */
    @Autowired
    @Qualifier("performanceImpl")
    private Performance performanceImpl;

    /**
     * 这里是自己new的类， 切面没有生效
     */
    @Test
    public void test1() {
        Performance performance = () -> System.out.println("perform");
        performance.perform();
    }

    @Test
    public void test2() {
        performance.perform();
    }

    @Test
    public void test3() {
        performanceImpl.perform();
    }
}
