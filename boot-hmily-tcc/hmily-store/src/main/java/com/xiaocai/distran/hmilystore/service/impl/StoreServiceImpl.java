package com.xiaocai.distran.hmilystore.service.impl;

import com.xiaocai.distran.hmilystore.mapper.StoreMapper;
import com.xiaocai.distran.hmilystore.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.core.holder.HmilyTransactionHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/13 17:25
 * @version: v1.0
 */
@Service
@Slf4j
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirmDecrease" , cancelMethod = "cancelDecrease")
    public boolean decreaseStore(Integer prodId, Integer number, Integer userId) {
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();

        boolean flag = false ;
        log.info("----- decrease Store try ... transId : " + transId );

        return true;
    }

    public boolean confirmDecrease(Integer prodId, Integer number, Integer userId) {


        log.info("----- confirm decrease  store ----");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- confirm decrease  store  transId : " + transId );

        boolean flag = false ;
        log.info("----开始执行扣减库存操作-----");
        int i = storeMapper.updateStoreByProdId(prodId, number);

        return true;
    }

    public boolean cancelDecrease(Integer prodId, Integer number, Integer userId) {
        log.info("----- cancel decrease  store ----");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- cancel decrease  store  transId : " + transId );

        return true;
    }
}
