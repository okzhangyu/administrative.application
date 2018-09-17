package com.avatech.administrative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by asus on 2018/9/7.
 */



@SpringBootApplication(exclude =DataSourceAutoConfiguration.class)
@ComponentScan("com.avatech.administrative")
public class AdminApplication {
    public static void main(String args[]){
        SpringApplication.run(AdminApplication.class,args);
    }
}
