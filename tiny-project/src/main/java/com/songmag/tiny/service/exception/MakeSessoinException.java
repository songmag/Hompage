package com.songmag.tiny.service.exception;

import java.util.HashMap;
import java.util.Map;

public class MakeSessoinException extends SongException{
    String errorCd;
    String errorMsg;
    String ip;

    public MakeSessoinException(String errCd, String errMsg,String ip){
        errorCd = errCd;
        errorMsg = errMsg;
        ip = ip;
    }

    @Override
    public String getMessage() {
        return "Error CD::"+errorCd+"\n MSG::"+errorMsg + "\n IP :: " + ip;
    }

    @Override
    public String toString() {
        return "Error CD::"+errorCd+"\n MSG::"+errorMsg + "\n IP :: " + ip;
    }
}
