package com.xiaocai.distran.serverstore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description: TODO 功能角色说明：
 * TODO 描述：
 * @author: 张小菜
 * @date: 2020/11/12 19:14
 * @version: v1.0
 */
@Data
@NoArgsConstructor
@ToString
public class StorageBean {

    private Integer id ;
    private Integer prodId ;
    private String prodName ;
    private double prodPrice ;
    private Integer storage ;
}
