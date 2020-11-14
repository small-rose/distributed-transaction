package com.xiaocai.distran.hmilyorder.openfeign.fallback;

import com.xiaocai.distran.hmilyorder.openfeign.AccountClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/13 20:12
 * @version: v1.0
 */
@Component
@Slf4j
public class AccountFallBack implements AccountClient {

    @Override
    public boolean decreaseAccount(Integer userId, double prodPrice) {
        log.info("----account fall back -----");
        return false;
    }
}
