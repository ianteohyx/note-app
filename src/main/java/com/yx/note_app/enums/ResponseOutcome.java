package com.yx.note_app.enums;

public enum ResponseOutcome {
    SUCCESS(true,"SUCCESS", "success"),
    PROCESS_FAIL(false, "PROCESS_FAIL", "process fail"),
    PARAM_ILLEGAL(false, "PARAM_ILLEGAL", "parameter in request causing error"),
    USERNAME_EXIST(false, "USERNAME_EXIST", "this username has been taken"),
    USER_NOT_EXIST(false, "USER_NOT_EXIST", "this user does not exist"),
    PASSWORD_INVALID(false, "INVALID_PASSWORD", "password format invalid"),
    LOGIN_FAIL(false, "LOGIN_FAIL", "login fail"),
    TOKEN_INVALID(false, "TOKEN_INVALID", "token is invalid"),
    NOTE_NOT_EXIST(false, "NOTE_NOT_EXIST", "note does not exist"),
    NOTE_NOT_SHARED(false, "NOTE_NOT_SHARED", "note is note shared to this user"),
    ACTION_NOT_ALLOWED(false, "ACTION_NOT_ALLOWED", "this action is not allowed"),
    NOTE_ALREADY_SHARED(false, "NOTE_ALREADY_SHARED", "this note already shared to the same user");

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
