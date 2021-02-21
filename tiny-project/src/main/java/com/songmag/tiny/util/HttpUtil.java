package com.songmag.tiny.util;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {

    public static String getIp(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR");
        if(ip == null){
           ip = request.getRemoteAddr();
        }
        return ip;
    }
}
