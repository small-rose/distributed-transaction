package com.xiaocai.distran.hmilyorder.constants;

public enum OrderStatusEnum {

    NOT_PAY(1, "未支付"),
    PAYING(2, "支付中"),
    PAY_SECCESS(3, "支付成功"),
    PAY_FAIL(4,"支付失败");

    private final int code ;
    private final String desc ;
    OrderStatusEnum(int code, String desc){
        this.code = code;
        this.desc = desc ;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
