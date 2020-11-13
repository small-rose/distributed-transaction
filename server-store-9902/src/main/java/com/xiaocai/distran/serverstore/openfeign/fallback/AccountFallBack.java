package com.xiaocai.distran.serverstore.openfeign.fallback;

import com.xiaocai.distran.serverstore.openfeign.AccountFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/12 18:58
 * @version: v1.0
 */
@Component
@Slf4j
public class AccountFallBack implements AccountFeignClient {

    @Override
    public boolean decreaseAccount(int userId, double money) {
        log.warn("----account fall back -----");
        return false;
    }
}
