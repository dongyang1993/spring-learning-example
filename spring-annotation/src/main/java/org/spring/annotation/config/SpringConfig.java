package org.spring.annotation.config;

import org.spring.annotation.bean.Car;
import org.spring.annotation.bean.CarWrapper;
import org.spring.annotation.bean.HelloWorld;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/**
 * basePackages里面放的是一个数组==> basePackages = {"dir1", "dir2"} 如此即可
 */
@ComponentScan(basePackages = {"org.spring.annotation"})
@ImportResource(value = {"classpath:applicationContext.xml"})
@PropertySource(value = {"classpath:config.properties"})
@Configuration
public class SpringConfig {

    /**
     * 方式一：
     * BeanId 默认为helloWorld 方法首字母小写的名字
     * @return
     */
    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMsg("helloWorld");
        return helloWorld;
    }

    /**
     * 方式二：指定BeanId
     * @return
     */
    @Bean("helloWorld2M")
    public HelloWorld helloWorld2() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMsg("helloWorld2");
        return helloWorld;
    }

    /**
     * 下面两个carWrapper因为本类中有car Bean除非指定用哪个Bean 不然默认会优先取本类中的
     * @return
     */
    @Bean
    public Car car() {
        Car car = new Car();
        car.setName("Bean Car");
        return car;
    }

    /**
     * 构造器注入
     * @param car
     * @return
     */
    @Bean("carWrapper")
    public CarWrapper carWrapper(@Qualifier("carc") Car car) {
        return new CarWrapper(car);
    }

    @Bean("carWrapper2")
    public CarWrapper carWrapper2(@Qualifier("car") Car car) {
        return new CarWrapper(car);
    }

}
