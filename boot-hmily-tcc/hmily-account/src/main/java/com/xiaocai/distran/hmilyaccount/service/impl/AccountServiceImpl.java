package com.xiaocai.distran.hmilyaccount.service.impl;

import com.xiaocai.distran.hmilyaccount.mapper.AccountMapper;
import com.xiaocai.distran.hmilyaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/13 17:32
 * @version: v1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirmDecreaseAccount", cancelMethod = "cancelDecreaseAccount")
    public boolean tryDecreaseAccount(int userId, double money) {

        log.info("----- confirm decrease  account ----- ");
        //Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        //log.info("----- confirm decrease  account  transId : ");

        log.info("---- 执行 Try 扣减账户余额-----");
        int i = accountMapper.tryDecreaseAccount(userId, money);
        if(i <= 0 ){
            throw new RuntimeException("Try 扣减账户余额失败");
        }
        log.info("----  Try 扣减账户余额完成-----");

        return Boolean.TRUE;
    }


    public boolean confirmDecreaseAccount(int userId, double money) {
        log.info("----- confirm decrease  account ----- ");
        //Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        //log.info("----- confirm decrease  account  transId : " + transId );

        log.info("---- 执行扣减账户余额-----");
        int i = accountMapper.confirmDecreaseAccount(userId, money);
        if(i <= 0 ){
            throw new RuntimeException("Confirm 扣减账户余额失败");
        }
        log.info("---- 扣减账户余额完成-----");

        return Boolean.TRUE;
    }


    public boolean cancelDecreaseAccount(int userId, double money) {
        log.info("----- cancel decrease  account ----- ");
        //Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        //log.info("----- cancel decrease  account  transId : " + transId );

        log.info("---- 取消扣减账户余额-----");
        int  i = accountMapper.cancelDecreaseAccount(userId, money);
        if(i <= 0 ){
            throw new RuntimeException("Cancel 扣减账户余额失败");
        }
        log.info("---- 取消账户余额完成-----");

        return Boolean.TRUE;
    }

}
