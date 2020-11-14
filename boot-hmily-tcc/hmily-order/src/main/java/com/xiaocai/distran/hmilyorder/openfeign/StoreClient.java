package com.xiaocai.distran.hmilyorder.openfeign;

import com.xiaocai.distran.hmilyorder.openfeign.fallback.StoreFallBack;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "hmily-store", fallback = StoreFallBack.class )
public interface StoreClient {

    @RequestMapping(value = "/v1/store/decrease" ,method = RequestMethod.POST)
    @Hmily
    public boolean updateStore(@RequestParam("prodId") Integer prodId, @RequestParam("number") Integer number);
}
