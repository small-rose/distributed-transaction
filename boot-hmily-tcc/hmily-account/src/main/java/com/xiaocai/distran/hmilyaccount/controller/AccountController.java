package com.xiaocai.distran.hmilyaccount.controller;

import com.xiaocai.distran.hmilyaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/13 21:37
 * @version: v1.0
 */
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/v1/account/decrease" ,method = RequestMethod.POST)
    public boolean decreaseAccount(@Param("userId") int userId, @Param("prodPrice") double prodPrice){
        //log.info("---decreaseAccount  XID : "+ RootContext.getXID());
        log.info(" receive param userId = "+userId);
        log.info(" receive param prodPrice = "+prodPrice);
        boolean bool = accountService.decreaseAccount(userId,prodPrice);
        return bool;
    }

}
