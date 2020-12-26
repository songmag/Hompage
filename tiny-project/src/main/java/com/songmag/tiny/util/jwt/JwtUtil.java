package com.songmag.tiny.util.jwt;

import com.google.gson.Gson;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

public abstract class JwtUtil {
    private static final Gson gson = new Gson();
    protected KeyUtil keyUtil;

    public JwtUtil(KeyUtil util){
        this.keyUtil = util;
    }
    public String getJwt(Map<String,Object> map,String method) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String payload = getPayLoad(map);
        String header = getHeader(method);
        StringBuilder builder= new StringBuilder(header);
        builder.append(".").append(payload);
        String temp = builder.toString();
        builder.setLength(0);
        builder.append(temp).append(".").append(Base64.encodeBase64URLSafeString(sign(temp)));
        return builder.toString();
    }
    protected abstract byte[] sign(String value) throws NoSuchAlgorithmException, InvalidKeyException;
    /**
     *  value 의 값의 유효기간을 설정한다.
     * @param value
     * @return
     */
    private String getPayLoad(Map<String,Object> value) {
        Long time = getTime();
        value.put("iat",time);
        value.put("exp",time + (3600L));
        return Base64.encodeBase64URLSafeString(gson.toJson(value).getBytes());
    }
    private String getPayLoad(Map<String,Object> value, Long expireTime){
        Long time = getTime();
        value.put("iat",time);
        value.put("exp",time + expireTime);
        return Base64.encodeBase64URLSafeString(gson.toJson(value).getBytes());
    }
    private Long getTime(){
        long convert = 1000L;
        Long time = System.currentTimeMillis()/convert;
        return time;
    }
    private String getHeader(String method){
        String type = "JWT";
        String alg = (method != null)? method :"RS256";
        Map<String,String> map = new HashMap<String,String>();
        map.put("type","JWT");
        map.put("alg",method);
        String json = gson.toJson(map);
        return Base64.encodeBase64URLSafeString(json.getBytes());
    }
}
