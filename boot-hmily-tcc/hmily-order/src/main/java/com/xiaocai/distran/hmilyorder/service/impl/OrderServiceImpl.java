package com.xiaocai.distran.hmilyorder.service.impl;

import com.xiaocai.distran.hmilyorder.bean.OrderBean;
import com.xiaocai.distran.hmilyorder.constants.OrderStatusEnum;
import com.xiaocai.distran.hmilyorder.mapper.OrderMapper;
import com.xiaocai.distran.hmilyorder.service.OrderService;
import com.xiaocai.distran.hmilyorder.service.PayService;
import lombok.extern.slf4j.Slf4j;
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
    private PayService payService;

    @Override
    public String creatOrder(int prodId, Integer count, Double amount) {
        OrderBean order = saveOrder(prodId, count, amount);
        payService.payAccount(order);
        return "success";
    }



    private OrderBean saveOrder(int prodId, Integer count, Double amount) {
        final OrderBean order = buildOrder(prodId, count, amount);
        orderMapper.createOrder(order);
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
