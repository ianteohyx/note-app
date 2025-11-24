package com.yx.note_app.enums;

public enum Permission {
    READ("READ", "for read access only"),
    WRITE("WRITE", "for read and write access");

    private final String code;
    private final String desc;

    Permission(String code, String desc) {
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
