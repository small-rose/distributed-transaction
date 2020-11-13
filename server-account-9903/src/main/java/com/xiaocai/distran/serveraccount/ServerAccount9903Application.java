package com.xiaocai.distran.serveraccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerAccount9903Application {

    public static void main(String[] args) {

        SpringApplication.run(ServerAccount9903Application.class, args);
    }

}
