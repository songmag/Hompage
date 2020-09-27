package com.songmag.tiny.util;

import org.springframework.stereotype.Component;

public final class StringUtil{
    public static boolean isBlank(String value){
        if(value == null || "".equals(value))return true;
        return false;
    }
    public static String null2String(final String value,final String value2)
    {
        if(isBlank(value))
        {
           return value2;
        }
        return value;
    }
}
