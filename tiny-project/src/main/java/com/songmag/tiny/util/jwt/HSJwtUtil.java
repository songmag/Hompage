package com.songmag.tiny.util.jwt;

import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HSJwtUtil extends JwtUtil {

    public HSJwtUtil(KeyUtil util) {
        super(util);
    }

    @Override
    public byte[] sign(String value) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] hash;
        MacEnum mac = MacEnum.HS256;
        System.out.println(keyUtil.getSecretKey());
        mac.value.init(new SecretKeySpec(keyUtil.getSecretKey().getBytes(),"HmacSHA256"));
        hash = mac.value.doFinal(value.getBytes());
        return hash;
    }
}
