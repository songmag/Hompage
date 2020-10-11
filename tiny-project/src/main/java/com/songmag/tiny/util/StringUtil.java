package com.songmag.tiny.util;

import org.springframework.stereotype.Component;

public final class StringUtil{
    public static boolean isBlank(String value){
        return value == null || "".equals(value);
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
