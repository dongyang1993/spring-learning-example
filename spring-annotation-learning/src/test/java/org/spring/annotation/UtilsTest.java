package org.spring.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.annotation.config.SpringConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ClassUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UtilsTest {

    /**
     * 通过ClassPathResource获取classpath目录下的文件
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        ClassPathResource resource = new ClassPathResource("config.properties");
        InputStream in = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        reader.lines().forEach(System.out::println);
        reader.close();
    }

    /**
     * 通过lassLoader获取classpath目录下的文件
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        reader.lines().forEach(System.out::println);
        reader.close();
    }

    /**
     * 运行时获取项目路径
     */
    @Test
    public void test3() {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
    }
}
