package com.xiaocai.distran.serverorder.controller;

import com.xiaocai.distran.serverorder.bean.OrderBean;
import com.xiaocai.distran.serverorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:00
 * @version: v1.0
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    private int num = 1 ;// 可以让测试的时候订单不一样

    /**
     *  事务测试入口
     * @param prodId
     * @return
     */

    @GetMapping(value = "/v1/order/add/{prodId}/{number}")
    public String addOrder(@PathVariable("prodId") int prodId, @PathVariable("number") Integer number){
        OrderBean orderBean = new OrderBean();
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        orderBean.setOrderId(format);
        orderBean.setUserId(202001);
        orderBean.setNumber(number);
        orderBean.setProdId(prodId);

        boolean bool = orderService.addOrder(orderBean);
        num++;
        return bool ? "下单成功" : "下单失败";
    }
}
