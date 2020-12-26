package com.songmag.tiny.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionalException extends SongException {
    private String serviceName;
    private static final Logger logger = LoggerFactory.getLogger("Transactional Error");
    private LocalDateTime localDateTime;

    public TransactionalException(String serviceName) {
        this.serviceName = serviceName;
        localDateTime = LocalDateTime.now();
    }

    @Override
    public String getMessage() {
        StringBuffer buffer = new StringBuffer("[");
        buffer.append(serviceName);
        buffer.append("] ");
        buffer.append(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        buffer.append(" :: ");
        buffer.append(super.getMessage());
        buffer.append("\n\n");
        return buffer.toString();
    }
    @Override
    public void printStackTrace() {
        logger.debug(getMessage());
    }
    @Override
    public void printStackTrace(PrintStream s) {
        logger.debug(getMessage());
    }
    @Override
    public void printStackTrace(PrintWriter s) {
        logger.debug(getMessage());
    }
}
