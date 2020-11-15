package com.xiaocai.distran.hmilystock.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StockMapper {

    /**
     *  预备扣减库存操作
     * @param prodId
     * @param count
     * @return
     */
    @Update("update wms_store set total_stock = total_stock - #{count}, lock_stock = lock_stock + #{count} where prod_id= #{prodId}")
    public Integer tryDecreaseStock(@Param("prodId") Integer prodId, @Param("count") Integer count);

    /**
     *  确认扣减库存
     * @param prodId
     * @param count
     * @return
     */
    @Update("update wms_store set lock_stock = lock_stock - #{count} " +
            "where prod_id = #{productId} and total_stock > 0 ")
    int confirmDecreaseStock(@Param("prodId") Integer prodId, @Param("count") Integer count);

    /**
     *  取消扣减库存
     * @param prodId
     * @param count
     * @return
     */
    @Update("update wms_store set total_stock = total_stock + #{count} ," +
            " lock_stock = lock_stock - #{count} " +
            " where prod_id = #{prodId}  and lock_stock > 0 ")
    int cancelDecreaseStock(@Param("prodId") Integer prodId, @Param("count") Integer count);

}
