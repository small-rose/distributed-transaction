package com.xiaocai.distran.serverstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ServerStore9902Application {

    public static void main(String[] args) {

        SpringApplication.run(ServerStore9902Application.class, args);
    }

}
