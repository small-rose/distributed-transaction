package com.xiaocai.distran.hmilystock.controller;

import com.xiaocai.distran.hmilystock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/13 17:24
 * @version: v1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/stock")
public class StockController {


    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/v1/decrease" ,method = RequestMethod.GET)
    public boolean decreaseStock(@RequestParam("prodId") Integer prodId, @RequestParam("count") Integer count){
        log.info(" receive param prodId = "+prodId);
        log.info(" receive param count = "+count);

        boolean bool = stockService.decreaseStock(prodId,count);
        return bool ;
    }

}

