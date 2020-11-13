package com.xiaocai.distran.serveraccount.service.impl;

import com.xiaocai.distran.serveraccount.mapper.AccountMapper;
import com.xiaocai.distran.serveraccount.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/12 18:53
 * @version: v1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean decreaseAccount(int userId, double money) {
        log.info("----decreaseAccount  XID : "+ RootContext.getXID());

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("----执行扣减账户余额-----");
        boolean bool = accountMapper.decreaseAccount(userId, money);
        log.info("----扣减账户余额完成-----"+ bool);
        return bool;
    }
}
