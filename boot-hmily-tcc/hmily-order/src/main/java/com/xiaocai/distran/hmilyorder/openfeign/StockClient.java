package com.xiaocai.distran.hmilyorder.openfeign;

import com.xiaocai.distran.hmilyorder.openfeign.fallback.StockFallBack;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "hmily-stock", path = "/stock", fallback = StockFallBack.class )
public interface StockClient {

    @Hmily
    @RequestMapping(value = "/v1/decrease" ,method = RequestMethod.GET)
    public boolean decreaseStock(@RequestParam("prodId") Integer prodId, @RequestParam("count") Integer count);
}
