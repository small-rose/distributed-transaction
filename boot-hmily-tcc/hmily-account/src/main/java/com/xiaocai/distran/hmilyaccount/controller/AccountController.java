package com.xiaocai.distran.hmilyaccount.controller;

import com.xiaocai.distran.hmilyaccount.service.AccountService;
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
 * @date: 2020/11/13 21:37
 * @version: v1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/v1/decrease" ,method = RequestMethod.GET)
    public boolean decreaseAccount(@RequestParam("userId") Integer userId, @RequestParam("amount") Double amount){
        //log.info("---decreaseAccount  XID : "+ RootContext.getXID());
        log.info(" receive param userId = "+userId);
        log.info(" receive param amount = "+amount);
        boolean bool = accountService.tryDecreaseAccount(userId, amount);
        return bool;
    }

}
