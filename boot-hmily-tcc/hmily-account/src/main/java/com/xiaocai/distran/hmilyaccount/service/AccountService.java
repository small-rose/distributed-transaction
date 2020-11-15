package com.xiaocai.distran.hmilyaccount.service;

public interface AccountService {

    boolean tryDecreaseAccount(int userId, double money);
}
