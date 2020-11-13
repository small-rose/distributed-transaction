package com.xiaocai.distran.serverorder;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableAutoDataSourceProxy
public class ServerOrder9901Application {

    public static void main(String[] args) {

        SpringApplication.run(ServerOrder9901Application.class, args);
    }

}
