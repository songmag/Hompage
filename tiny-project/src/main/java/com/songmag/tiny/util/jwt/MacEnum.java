package com.songmag.tiny.util.jwt;

import javax.crypto.Mac;
import java.security.NoSuchAlgorithmException;

public enum MacEnum {
    HS256("HmacSHA256");
    public Mac value;
    MacEnum(String value){
        try {
            this.value = Mac.getInstance(value);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static MacEnum getObject(String method) throws NoSuchAlgorithmException {
           if(method == "HS256")
           {
               return HS256;
           }
           else{
               throw new NoSuchAlgorithmException();
           }
    }
}
