package com.xiaocai.distran.hmilystore.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LocalLogMapper {

    /**
     *  当前分支操作日志记录
     * @param localTradeNo
     * @return
     */
    @Insert("INSERT INTO local_try_log values (#{localTradeNo} ,now());")
    int addTryLog(String localTradeNo);


    @Insert("INSERT INTO local_confirm_log values (#{localTradeNo} ,now());")
    int addConfirmLog(String localTradeNo);


    @Insert("INSERT INTO local_cancel_log values (#{localTradeNo} ,now());")
    int addCancelLog(String localTradeNo);


    @Select("SELECT COUNT(1) FROM local_try_log WHERE tx_no = #{txNo}")
    int existTryLog(String txNo);

    @Select("SELECT COUNT(1) FROM local_try_log WHERE tx_no = #{txNo}")
    int existConfirmLog(String txNo);

    @Select("SELECT COUNT(1) FROM local_try_log WHERE tx_no = #{txNo}")
    int existCancelLog(String txNo);
}
