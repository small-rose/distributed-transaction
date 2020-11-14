package com.xiaocai.distran.hmilyorder.controller;

import com.xiaocai.distran.hmilyorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:00
 * @version: v1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**  http://localhost:9911/v1/order/add/1001/1/120
     *  事务测试入口
     * @param prodId
     * @return
     */

    @GetMapping(value = "/v1/order/add/{prodId}/{count}/{amount}")
    public String createOrder(@PathVariable("prodId") int prodId,
                           @PathVariable("count") Integer count,
                           @PathVariable("amount") Double amount){

        String result = orderService.creatOrder(prodId, count, amount);
        return result;
    }
}
