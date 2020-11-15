package com.xiaocai.distran.hmilystock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableDiscoveryClient
@EnableTransactionManagement
public class HmilyStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmilyStockApplication.class, args);
    }

}
