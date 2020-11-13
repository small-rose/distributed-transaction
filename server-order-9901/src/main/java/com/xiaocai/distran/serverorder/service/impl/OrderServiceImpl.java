package com.xiaocai.distran.serverorder.service.impl;

import com.xiaocai.distran.serverorder.bean.OrderBean;
import com.xiaocai.distran.serverorder.mapper.OrderMapper;
import com.xiaocai.distran.serverorder.openfeign.StoreClient;
import com.xiaocai.distran.serverorder.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:01
 * @version: v1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StoreClient storeClient;


    //@GlobalTransactional
    @GlobalTransactional(timeoutMills = 60000 , rollbackFor = Exception.class)
    @Override
    public boolean addOrder(OrderBean orderBean) {
        log.info("create order begin ... xid: " + RootContext.getXID());
        boolean flag = false;
        //  本地事务保存订单
        orderMapper.addOrder(orderBean);

        // 远程调用扣减库存
        if (storeClient.decreaseStore(orderBean.getProdId(), orderBean.getNumber(), orderBean.getUserId())){
            flag = true;
        }
        if (orderBean.getNumber() == 100){
            //throw new RuntimeException("故意制造异常测试回滚操作");
            int x = 10/0 ;
        }

        return flag;
    }
}
