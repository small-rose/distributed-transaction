package com.xiaocai.distran.serverstore.service;

public interface StoreService {

   public boolean decreaseStore(Integer prodId, Integer number, Integer userId);
}
