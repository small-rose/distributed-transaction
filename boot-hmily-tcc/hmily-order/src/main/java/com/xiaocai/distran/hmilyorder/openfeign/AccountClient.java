package com.xiaocai.distran.hmilyorder.openfeign;

import com.xiaocai.distran.hmilyorder.openfeign.fallback.AccountFallBack;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "hmily-account", fallback = AccountFallBack.class )
public interface AccountClient {

    @RequestMapping(value = "/v1/account/decrease" ,method = RequestMethod.POST)
    @Hmily
    boolean decreaseAccount(@RequestParam("userId")  Integer userId, @RequestParam("prodPrice") double prodPrice);
}
