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
 * @Creation Date:2018-07-20
 * @SpringBootApplicatoin是用的@ComponentScan扫描，扫描的是Component，包括@Component, @Controller, @Service, @Repository等，
 * 而@EnableFeignClients扫描的是@FeignClient，所以在指定扫描路径时要分别指定，否则会报异常：
 * 1、添加依赖
 * 2、feign 在启动的主类上加 @EnableFeignClients
 * 3、声明调用哪个应用下的方法，此处案例中productClient 调用的是bronze-product应用中的 路径来定义 方法的
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = {"com.bronze.order.dao"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.bronze.product.client")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
