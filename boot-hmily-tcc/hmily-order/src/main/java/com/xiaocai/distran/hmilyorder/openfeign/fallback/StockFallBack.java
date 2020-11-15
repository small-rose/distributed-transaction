package com.xiaocai.distran.hmilyorder.openfeign.fallback;

import com.xiaocai.distran.hmilyorder.openfeign.StockClient;
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
public class StockFallBack implements StockClient {

    @Override
    public boolean decreaseStock(Integer prodId, Integer count) {
        log.info("-----Store Fall Back-----");
        return false;
    }
}
