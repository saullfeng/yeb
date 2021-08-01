package com.xxxx.server.pojo;

/**
 * @ClassName: NotificationMsg
 * @Description: TODO
 * @author: solfeng
 * @date: 2021/7/9  16:41
 */
public enum NotificationMsg {
    SUCCESS("000000", "Operation Success"),
    JOBLEVEL_FAILED("000001","joblevel-getid Fail"),

    ;

    private NotificationMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
