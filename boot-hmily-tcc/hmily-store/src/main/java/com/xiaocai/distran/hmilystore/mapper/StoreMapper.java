package com.xiaocai.distran.hmilystore.mapper;


import com.xiaocai.distran.hmilystore.bean.StorageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StoreMapper {

    /**
     *  扣减库存操作
     * @param prodId
     * @param number
     * @return
     */
    @Update("UPDATE wms_store set storage = storage - #{number} where prod_id= #{prodId}")
    public Integer updateStoreByProdId(@Param("prodId") Integer prodId, @Param("number") Integer number);

    /**
     *  查询价格用来扣款
     * @param prodId
     * @return
     */
    @Select("SELECT * FROM wms_store WHERE prod_id= #{prodId}")
    public StorageBean getStorageBeanByProId(@Param("prodId") Integer prodId);

}
