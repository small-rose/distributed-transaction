package com.xiaocai.distran.serverstore.service.impl;

import com.xiaocai.distran.serverstore.bean.StorageBean;
import com.xiaocai.distran.serverstore.openfeign.AccountFeignClient;
import com.xiaocai.distran.serverstore.mapper.StoreMapper;
import com.xiaocai.distran.serverstore.service.StoreService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 23:44
 * @version: v1.0
 */
@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreMapper storeMapper;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    public boolean decreaseStore(Integer prodId, Integer number, Integer userId) {
        boolean flag = false ;
        log.info("decreaseStore begin ... xid: " + RootContext.getXID());
        log.info("----开始执行扣减库存操作-----");
        int i = storeMapper.updateStoreByProdId(prodId, number);


        log.info("----查询商品价格-----");
        StorageBean storageBean = storeMapper.getStorageBeanByProId(prodId);
        log.info("----商品价格是-----" + storageBean.getProdPrice());
        log.info("----开始调用扣减账户操作-----");
        if(i >0  && accountFeignClient.decreaseAccount(userId, storageBean.getProdPrice())){
            flag = true ;
        }
        //flag = i > 0 ?  true : false ;
        return flag;
    }
}
