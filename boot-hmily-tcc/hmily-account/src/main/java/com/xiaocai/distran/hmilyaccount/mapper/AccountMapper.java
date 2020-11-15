package com.xiaocai.distran.hmilyaccount.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface AccountMapper {

    /**
     *  try 扣款
     * @param userId
     * @param amount
     * @return
     */
    @Update("update ams_account SET balance = balance - #{amount}, freeze_amount = freeze_amount + #{amount} WHERE user_id = #{userId} and balance >= #{amount}")
    public int tryDecreaseAccount(@Param("userId") int userId, @Param("amount") double amount);


    /**
     * 确认扣款
     * @param userId
     * @param amount
     * @return
     */
    @Update("update ams_account SET freeze_amount = freeze_amount - #{amount} WHERE user_id = #{userId} and balance >= #{amount}")
    public int confirmDecreaseAccount(@Param("userId") int userId, @Param("amount") double amount);

    /**
     * 取消扣款
     * @param userId
     * @param amount
     * @return
     */
    @Update("update ams_account SET balance = balance + #{amount}, freeze_amount = freeze_amount - #{amount} WHERE user_id = #{userId} and balance >= #{amount}")
    public int cancelDecreaseAccount(@Param("userId") int userId, @Param("amount") double amount);
}
