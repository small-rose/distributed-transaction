package com.xiaocai.distran.serveraccount.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper {

    @Update("UPDATE ams_account SET amount = amount - #{money}  WHERE user_id = #{userId} and amount >= #{money}")
    public boolean decreaseAccount(@Param("userId") int userId, @Param("money") double money);
}
