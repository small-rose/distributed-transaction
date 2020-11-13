package com.xiaocai.distran.serveraccount.controller;

import com.xiaocai.distran.serveraccount.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/12 18:52
 * @version: v1.0
 */
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/v1/account/decrease" ,method = RequestMethod.POST)
    public boolean decreaseAccount(@Param("userId") int userId, @Param("money") double money){
        log.info("---decreaseAccount  XID : "+ RootContext.getXID());
        log.info(" receive param userId = "+userId);
        log.info(" receive param money = "+money);
        boolean bool = accountService.decreaseAccount(userId,money);
        return bool;
    }

}
