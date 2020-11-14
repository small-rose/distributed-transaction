package com.xiaocai.distran.hmilyorder.service.impl;

import com.xiaocai.distran.hmilyorder.bean.OrderBean;
import com.xiaocai.distran.hmilyorder.constants.OrderStatusEnum;
import com.xiaocai.distran.hmilyorder.mapper.OrderMapper;
import com.xiaocai.distran.hmilyorder.openfeign.AccountClient;
import com.xiaocai.distran.hmilyorder.openfeign.StoreClient;
import com.xiaocai.distran.hmilyorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.core.holder.HmilyTransactionHolder;
import org.dromara.hmily.repository.spi.entity.HmilyTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/13 17:29
 * @version: v1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private AccountClient accountClient;

    @Override
    @HmilyTCC(confirmMethod = "orderConfirm", cancelMethod = "orderCancel")
    public String creatOrder(int prodId, Integer count, Double amount) {
        HmilyTransactionHolder instance = HmilyTransactionHolder.getInstance();
        HmilyTransaction currentTransaction = instance.getCurrentTransaction();
        Long transId = currentTransaction.getTransId();

        //String tranxsId = String.valueOf(HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId());
        log.info("try order tranxsId : {}", transId);

        OrderBean order = saveOrder(prodId, count, amount);
        long start = System.currentTimeMillis();
        // 扣减账户金额
        Boolean boolacct = accountClient.decreaseAccount(order.getUserId(),order.getTotalAmount());
        // 扣减库存
        Boolean boolstore = storeClient.updateStore(order.getProdId(),order.getNumbers());

        System.out.println("hmily-cloud分布式事务耗时：" + (System.currentTimeMillis() - start));

        if(!boolacct || !boolstore){ // 有一个失败事务就需要回滚
            throw new RuntimeException("出问题了，订单需要回滚");
        }

        //localLogMapper.addTryLog(tranxsId);

        return "success";
    }
    public String orderConfirm(int prodId, Integer count, Double amount) {
        log.info("----- confirm  add order ----");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- confirm  add order   transId : " + transId );

        return "订单确认成功";
    }
    public String orderCancel(int prodId, Integer count, Double amount) {
        log.info("----- cancel  add order ----");
        Long transId = HmilyTransactionHolder.getInstance().getCurrentTransaction().getTransId();
        log.info("----- cancel  add order   transId : " + transId );



        return "订单取消";
    }







    private OrderBean saveOrder(int prodId, Integer count, Double amount) {
        final OrderBean order = buildOrder(prodId, count, amount);
        orderMapper.addOrder(order);
        return order;
    }

    private OrderBean buildOrder(int prodId, Integer count, Double amount) {
        log.debug("构建订单对象");
        OrderBean order = new OrderBean();
        order.setProdId(prodId);
        order.setTotalAmount(amount);
        order.setNumbers(count);

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        order.setOrderId(format); // 用时间生成订单号，方便查看，真实的不可以这么玩
        order.setUserId(202001); // 表里只有一个用户

        order.setStatus(OrderStatusEnum.NOT_PAY.getCode());
        return order;
    }


}
