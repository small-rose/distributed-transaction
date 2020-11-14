package com.xiaocai.distran.hmilyorder.constants;

public enum OrderStatusEnum {

    NOT_PAY(0, "未支付"),
    PAY_SECCESS(1, "支付成功"),
    PAY_FAIL(1,"支付失败");

    private int code ;
    private String desc ;
    OrderStatusEnum(int code, String desc){
        this.code = code;
        this.desc = desc ;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
