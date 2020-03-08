package com.york.cloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  @Description:eureka服务端启动类
 *  @EnableEurekaServer 启用eureka的server
 *  @Author: York.Hwang
 *  @Date: 2020/3/5 23:12
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
