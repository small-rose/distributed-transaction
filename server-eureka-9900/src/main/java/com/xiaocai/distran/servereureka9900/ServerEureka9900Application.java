package com.xiaocai.distran.servereureka9900;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerEureka9900Application {

    public static void main(String[] args) {

        SpringApplication.run(ServerEureka9900Application.class, args);
    }

}
