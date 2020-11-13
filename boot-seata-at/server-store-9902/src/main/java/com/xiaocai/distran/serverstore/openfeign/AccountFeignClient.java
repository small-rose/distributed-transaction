package com.xiaocai.distran.serverstore.openfeign;

import com.xiaocai.distran.serverstore.openfeign.fallback.AccountFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/12 18:56
 * @version: v1.0
 */
@Component
@FeignClient(value = "server-account", fallback = AccountFallBack.class )
public interface AccountFeignClient {


    @RequestMapping(value = "/v1/account/decrease" ,method = RequestMethod.POST)
    public boolean decreaseAccount(@RequestParam("userId") int userId, @RequestParam("money") double money);

}
