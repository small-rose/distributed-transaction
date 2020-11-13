package com.xiaocai.distran.serverstore.controller;

import com.xiaocai.distran.serverstore.service.StoreService;
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
 * @date: 2020/11/9 23:43
 * @version: v1.0
 */
@RestController
@Slf4j
public class StoreController {


    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/v1/store/decrease" ,method = RequestMethod.POST)
    public boolean updateStore(@RequestParam("prodId") Integer prodId, @RequestParam("number") Integer number, @RequestParam("userId") Integer userId){
        log.info(" receive param prodId = "+prodId);
        log.info(" receive param number = "+number);
        log.info(" receive param userId = "+userId);
        boolean bool = storeService.decreaseStore(prodId,number,userId);
        return bool ;
    }

}
