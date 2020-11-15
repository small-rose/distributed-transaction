package com.xiaocai.distran.hmilystock.service.impl;

import com.xiaocai.distran.hmilystock.mapper.StockMapper;
import com.xiaocai.distran.hmilystock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
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
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirmDecreaseStock" , cancelMethod = "cancelDecreaseStock")
    public boolean decreaseStock(Integer prodId, Integer count) {

        log.info("----- decrease Store try ... " );

        log.info("----开始执行 try 扣减库存操作-----");
        int i = stockMapper.tryDecreaseStock(prodId, count);

        if(i <= 0 ){
            throw new RuntimeException("try 扣减库存失败");
        }
        log.info("----执行 try 扣减库存操作成功-----");

        return Boolean.TRUE;
    }

    public boolean confirmDecreaseStock(Integer prodId, Integer count) {

        log.info("----- confirm decrease  store ----");
        //Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        //log.info("----- confirm decrease  store  transId : " + transId );

        log.info("----开始执行 确认扣减库存操作-----");
        int i = stockMapper.confirmDecreaseStock(prodId, count);
        if(i <= 0 ){
            throw new RuntimeException("confirm 扣减库存失败");
        }

        log.info("----执行 确认扣减库存 操作成功-----");

        return Boolean.TRUE;
    }

    public boolean cancelDecreaseStock(Integer prodId, Integer count) {
        log.info("----- cancel decrease  store ----");
        //Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        //log.info("----- cancel decrease  store  transId : " + transId );

        log.info("----开始执行 取消扣减库存 操作-----");
        int i = stockMapper.cancelDecreaseStock(prodId, count);
        if(i <= 0 ){
            throw new RuntimeException("confirm 扣减库存失败");
        }

        log.info("----执行 取消扣减库存 操作成功-----");
        return Boolean.TRUE;
    }
}
