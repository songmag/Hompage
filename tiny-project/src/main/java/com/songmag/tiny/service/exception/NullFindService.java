package com.songmag.tiny.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.io.PrintWriter;

public class NullFindService extends SongException{
    private String message;
    private String className;

    private Logger logger = LoggerFactory.getLogger(NullFindService.class);
    public NullFindService(String message, String className){
            this.message = message;
            this.className = className;
    }
    @Override
    public void printStackTrace() {
        logger.debug("Service Not Fount:: " + className + "\n Message ::" + message);
    }
    @Override
    public void printStackTrace(PrintWriter s) {
        logger.debug("Service Not Fount:: " + className + "\n Message ::" + message);
        s.println("Service Not Found " + this.message);
    }

    @Override
    public void printStackTrace(PrintStream s) {
        logger.debug("Service Not Fount:: " + className + "\n Message ::" + message);
        s.println("Service Not Found " + this.message);
    }
}


