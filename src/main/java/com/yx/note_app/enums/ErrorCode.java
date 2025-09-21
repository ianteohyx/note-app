package com.yx.note_app.enums;

public enum ErrorCode {
    PROCESS_FAIL("PROCESS_FAIL", "process fail"),
    PARAM_ILLEGAL("PARAM_ILLEGAL", "parameter in request causing error"),
    USERNAME_EXIST("USERNAME_EXIST", "this username has been taken"),
    PASSWORD_INVALID("INVALID_PASSWORD", "password format invalid");

    private final String code;
    private final String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
