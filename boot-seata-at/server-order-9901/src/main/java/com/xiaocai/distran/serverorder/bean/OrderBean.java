package com.xiaocai.distran.serverorder.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/9 22:41
 * @version: v1.0
 */
@Data
@NoArgsConstructor
@ToString
public class OrderBean implements Serializable {

    private Integer  id ;
    private String  orderId ; // 订单ID
    private Integer  userId; // 用户ID
    private Integer  prodId ;//商品ID // 假设每次只买一种商品
    private Integer  number ; // 订单里的商品数量
}
