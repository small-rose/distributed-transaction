package com.xiaocai.distran.serverstore.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/12 17:21
 * @version: v1.0
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.application.name}")
    private String appId ;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {

        return new DruidDataSource();
    }





}
