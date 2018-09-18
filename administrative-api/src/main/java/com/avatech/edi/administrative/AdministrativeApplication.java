package com.avatech.edi.administrative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.avatech.edi")
public class AdministrativeApplication  {

    public static void main(String args[]){
        SpringApplication.run(AdministrativeApplication.class,args);
    }
}
