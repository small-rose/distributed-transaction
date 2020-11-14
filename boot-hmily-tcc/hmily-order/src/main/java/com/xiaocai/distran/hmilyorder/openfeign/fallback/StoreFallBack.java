package com.xiaocai.distran.hmilyorder.openfeign.fallback;

import com.xiaocai.distran.hmilyorder.openfeign.StoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/14 0:55
 * @version: v1.0
 */
@Component
@Slf4j
public class StoreFallBack implements StoreClient {

    @Override
    public boolean updateStore(Integer prodId, Integer number) {
        log.info("-----Store Fall Back-----");
        return false;
    }
}
