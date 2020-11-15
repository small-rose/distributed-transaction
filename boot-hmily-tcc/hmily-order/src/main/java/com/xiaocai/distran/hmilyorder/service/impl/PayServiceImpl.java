package com.xiaocai.distran.hmilyorder.service.impl;

import com.xiaocai.distran.hmilyorder.bean.OrderBean;
import com.xiaocai.distran.hmilyorder.constants.OrderStatusEnum;
import com.xiaocai.distran.hmilyorder.mapper.OrderMapper;
import com.xiaocai.distran.hmilyorder.openfeign.AccountClient;
import com.xiaocai.distran.hmilyorder.openfeign.StockClient;
import com.xiaocai.distran.hmilyorder.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.core.holder.HmilyTransactionHolder;
import org.dromara.hmily.repository.spi.entity.HmilyTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/15 10:51
 * @version: v1.0
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StockClient stockClient;
    @Autowired
    private AccountClient accountClient;

    /**
     *  扣减账户金额，扣减库存
     * @param order
     */
    @Override
    @HmilyTCC(confirmMethod = "orderConfirm", cancelMethod = "orderCancel")
    public void payAccount(OrderBean order){
        HmilyTransactionHolder instance = HmilyTransactionHolder.getInstance();
        HmilyTransaction currentTransaction = instance.getCurrentTransaction();
        Long transId = currentTransaction.getTransId();
        long start = System.currentTimeMillis();

        //String tranxsId = String.valueOf(HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId());
        log.info("try order tranxsId : {}", transId);

        orderMapper.updateStatus(order.getOrderId(), OrderStatusEnum.PAYING.getCode());
        // 扣减账户金额
        Boolean boolacct = accountClient.decreaseAccount(order.getUserId(), order.getTotalAmount());
        // 扣减库存
        Boolean boolstore = stockClient.decreaseStock(order.getProdId(), order.getNumbers());

        System.out.println("hmily-cloud分布式事务耗时：" + (System.currentTimeMillis() - start));

        if(!boolacct || !boolstore){ // 有一个失败事务就需要回滚
            throw new RuntimeException("decrease account or decrease stock failed，订单需要回滚");
        }
    }

    public void orderConfirm(OrderBean order) {
        log.info("----- confirm  add order ----");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- confirm  add order   transId : " + transId );

        orderMapper.updateStatus(order.getOrderId(), OrderStatusEnum.PAY_SECCESS.getCode());
        log.info("----- 确认订单支付成功- -------- ");
    }


    public void orderCancel(OrderBean order) {
        log.info("----- cancel  add order ----");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- cancel  add order   transId : " + transId );

        orderMapper.updateStatus(order.getOrderId(), OrderStatusEnum.PAY_FAIL.getCode());
        log.info("----- 确认订单支付失败- -------- ");

    }

}
