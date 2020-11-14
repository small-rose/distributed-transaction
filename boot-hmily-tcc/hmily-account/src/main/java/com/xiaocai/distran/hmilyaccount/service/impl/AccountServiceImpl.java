package com.xiaocai.distran.hmilyaccount.service.impl;

import com.xiaocai.distran.hmilyaccount.mapper.AccountMapper;
import com.xiaocai.distran.hmilyaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.core.holder.HmilyTransactionHolder;
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
    @HmilyTCC(confirmMethod = "confirmDecrease", cancelMethod = "cancelDecrease")
    public boolean decreaseAccount(int userId, double money) {
        log.info("----- try decrease  account ----- ");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- try decrease  account  transId : " + transId );

        return true;
    }

    public boolean confirmDecrease(int userId, double money) {
        log.info("----- confirm decrease  account ----- ");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- confirm decrease  account  transId : " + transId );

        log.info("----执行扣减账户余额-----");
        boolean bool = accountMapper.decreaseAccount(userId, money);
        log.info("----扣减账户余额完成-----"+ bool);

        return true;
    }


    public boolean cancelDecrease(int userId, double money) {
        log.info("----- cancel decrease  account ----- ");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- cancel decrease  account  transId : " + transId );

        return true;
    }

}
