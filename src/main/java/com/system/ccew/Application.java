package com.system.ccew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author finderlo
 * @date 06/05/2017
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.system.ccew")
public class Application {
//jery
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
