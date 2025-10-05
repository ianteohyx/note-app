package com.yx.note_app.enums;

public enum ResponseOutcome {
    SUCCESS(true,"SUCCESS", "success"),
    PROCESS_FAIL(false, "PROCESS_FAIL", "process fail"),
    PARAM_ILLEGAL(false, "PARAM_ILLEGAL", "parameter in request causing error"),
    USERNAME_EXIST(false, "USERNAME_EXIST", "this username has been taken"),
    PASSWORD_INVALID(false, "INVALID_PASSWORD", "password format invalid");

    private final boolean success;
    private final String code;
    private final String desc;

    ResponseOutcome(boolean success, String code, String desc) {
        this.success = success;
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public boolean getSuccess(){return success;}
}
