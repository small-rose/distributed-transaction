package com.xiaocai.distran.serverorder.mapper;

import com.xiaocai.distran.serverorder.bean.OrderBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {


    @Select("SELECT * FROM oms_order where order_id=#{orderId} ")
    List<OrderBean> findOrderById(Integer  id);

    @Insert("INSERT INTO oms_order (order_id,user_id,prod_id)values(#{orderId}, #{userId}, #{prodId})")
    Integer  addOrder(OrderBean order);

    @Delete("DELETE FROM oms_order WHERE order_id=#{orderId}")
    Integer  deleteByOrderId(Integer  orderId);

}
