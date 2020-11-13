package com.xiaocai.distran.serverstore.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:39
 * @version: v1.0
 */
@Configuration
@MapperScan(basePackages = {"com.xiaocai.distran.serverstore.mapper"})
public class GlobalConfig {


}
