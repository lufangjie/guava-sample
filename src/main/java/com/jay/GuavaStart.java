package com.jay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName GuavaStart
 * @Description TODO
 * @Date 2019/3/15
 * @Author lufangjie
 * @Version 1.0
 **/
@ComponentScan(value = "com.jay.guava")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GuavaStart {

    public static void main(String[] args){
        SpringApplication.run(GuavaStart.class);
    }
}
