package com.xiaocai.distran.hmilystore.service;

public interface StoreService {

    boolean decreaseStore(Integer prodId, Integer number, Integer userId);
}
