package com.bronze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Don
 * @version V1.0
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Creation Date:2018-07-20
 * @SpringBootApplicatoin是用的@ComponentScan扫描，扫描的是Component，包括@Component, @Controller, @Service, @Repository等，
 * 而@EnableFeignClients扫描的是@FeignClient，所以在指定扫描路径时要分别指定，否则会报异常：
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.bronze.order.admin.client")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
