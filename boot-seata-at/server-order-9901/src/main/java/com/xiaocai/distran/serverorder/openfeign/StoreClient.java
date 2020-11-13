package com.xiaocai.distran.serverorder.openfeign;

import com.xiaocai.distran.serverorder.openfeign.fallback.StoreFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:55
 * @version: v1.0
 */
@Component
@FeignClient(value = "server-store", fallback = StoreFallBack.class )
public interface StoreClient {

    /**
     *  调用扣减库存操作
     * @param prodId
     * @param number
     * @param userId
     * @return
     */
    @RequestMapping(value = "/v1/store/decrease" ,method = RequestMethod.POST)
    public boolean decreaseStore(@RequestParam("prodId") Integer prodId,
                                 @RequestParam("number") Integer number,
                                 @RequestParam("userId") Integer userId);

}
