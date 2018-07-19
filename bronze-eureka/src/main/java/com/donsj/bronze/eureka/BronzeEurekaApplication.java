package com.donsj.bronze.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BronzeEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BronzeEurekaApplication.class, args);
    }
}
