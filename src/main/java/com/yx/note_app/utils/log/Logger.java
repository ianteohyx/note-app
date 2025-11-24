package com.yx.note_app.utils.log;

import java.time.format.DateTimeFormatter;

public abstract class Logger {
    protected final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    protected Class<?> clazz;

    public Logger(Class<?> clazz) {
        this.clazz = clazz;
    }

    public abstract void log(String message);
}
