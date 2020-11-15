package com.xiaocai.distran.hmilyorder.mapper;


import com.xiaocai.distran.hmilyorder.bean.OrderBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {

    @Insert("INSERT INTO oms_order (order_id, user_id, prod_id, numbers, status, total_amount) values(#{orderId}, #{userId}, #{prodId}, #{numbers}, #{status}, #{totalAmount})")
    public boolean createOrder(OrderBean order);

    /**
     * 修改订单状态
     * @param orderId
     * @param status
     * @return
     */
    @Update("update oms_order set status = ${status}, update_time= now() where order_id = #{orderId}")
    public int updateStatus(@Param("orderId") String orderId, @Param("status") Integer status);


}
