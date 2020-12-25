package com.songmag.tiny.util.jwt;

import lombok.SneakyThrows;

import java.security.*;

public class RsaJwtUtil extends JwtUtil {


    public RsaJwtUtil(KeyUtil util) {
        super(util);
    }


    @SneakyThrows
    @Override
    public byte[] sign(String value) throws NoSuchAlgorithmException, InvalidKeyException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign((PrivateKey) keyUtil.getKeyset().get("privateKey"));
        signature.update(value.getBytes("utf-8"));
        return signature.sign();
    }
}
