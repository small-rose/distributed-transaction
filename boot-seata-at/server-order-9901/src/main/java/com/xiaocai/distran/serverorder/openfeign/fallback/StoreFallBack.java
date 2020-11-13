package com.xiaocai.distran.serverorder.openfeign.fallback;

import com.xiaocai.distran.serverorder.openfeign.StoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:58
 * @version: v1.0
 */
@Component
@Slf4j
public class StoreFallBack implements StoreClient {

   @Override
   public boolean decreaseStore(Integer prodId, Integer number, Integer userId) {
      log.info("---call store fall back---");
      return false;
   }
}
