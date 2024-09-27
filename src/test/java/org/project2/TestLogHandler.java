package org.project2;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TestLogHandler extends Handler {
    private StringBuilder logBuilder = new StringBuilder();

    @Override
    public void publish(LogRecord record) {
        logBuilder.append(record.getMessage()).append("\n");
    }

    @Override
    public void flush() { }

    @Override
    public void close() throws SecurityException { }

    public String getCapturedLogs() {
        return logBuilder.toString();
    }
}