package com.songmag.tiny.service.exception;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.PrintWriter;

public class UserFindException extends SongException{
    private String id;
    public UserFindException(String id){
        this.id = id;
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        s.println("USER ID "+ id + "존재하지 않습니다.");
    }
}
