package com.xiaocai.distran.serverstore.mapper;

import com.xiaocai.distran.serverstore.bean.StorageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StoreMapper {

    /**
     *  扣减库存操作
     * @param prodId
     * @param number
     * @return
     */
    @Update("UPDATE wms_store set storage = storage - #{number} where prod_id= #{prodId}")
    public Integer updateStoreByProdId(@Param("prodId") Integer prodId, @Param("number") Integer number);


    @Select("SELECT * FROM wms_store WHERE prod_id= #{prodId}")
    public StorageBean getStorageBeanByProId(@Param("prodId") Integer prodId);

}
