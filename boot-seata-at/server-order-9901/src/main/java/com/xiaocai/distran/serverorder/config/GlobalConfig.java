package com.xiaocai.distran.serverorder.config;

import feign.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:39
 * @version: v1.0
 */
@Configuration
@MapperScan(basePackages = {"com.xiaocai.distran.serverorder.mapper"})
public class GlobalConfig {


    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }



}
