package com.yx.note_app.utils;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class DefaultLogger extends Logger{
    private final String LOG_FILE_PATH = Paths.get("logs", "default.txt").toString();

    public DefaultLogger(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public void log(String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logLine = String.format("\n[%s] [%s] %s", timestamp, this.clazz.getSimpleName(), message);

        try {
            FileWriter writer = new FileWriter(LOG_FILE_PATH, true);
            writer.write(logLine);
            writer.close();
        } catch (IOException e) {
            System.out.println("write fail into default log");
        }
    }
}

