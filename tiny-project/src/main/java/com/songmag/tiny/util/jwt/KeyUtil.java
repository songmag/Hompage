package com.songmag.tiny.util.jwt;


import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public final class KeyUtil {
    private Map<String,Object> keySet;
    private String secretKey;
    private String keyFile;


    private KeyUtil(){};
    public Map<String,Object> getKeyset(){
        return keySet;
    }
    public String getSecretKey(){
        return secretKey;
    }
    private void setKeySet(String publicKey,String privateKey) {
        String publicKeyStr = getPublicKey(publicKey);
        String privateKeyStr  = getPrivateKey(privateKey);
        keySet = new HashMap<String,Object>();
        keySet.put("publicKey",string2PublicKey(publicKeyStr));
        keySet.put("privateKey",string2PrivateKey(privateKeyStr));
    }

    private void setKeySetFile(String publicKeyFile,String privateKeyFile) throws IOException {
        File  file = new File(publicKeyFile);
        File file2 = new File(privateKeyFile);
        if(!file.exists() || !file2.exists()){
            throw new RuntimeException("Public Key File 이 존재하지 않습니다. 다시 확인 부탁드립니다.");
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String temp;
        while((temp = reader.readLine()) != null){
            builder.append(temp);
        };
        String publicKey = getPublicKey(builder.toString());
        reader.close();
        builder.setLength(0);
        reader = new BufferedReader(new FileReader(file2));
        while((temp = reader.readLine()) != null){
            builder.append(temp);
        };
        String privateKey = getPrivateKey(builder.toString());
        reader.close();
        builder.setLength(0);
        keySet = new HashMap<String,Object>();
        keySet.put("publicKey",string2PublicKey(publicKey));
        keySet.put("privateKey",string2PrivateKey(privateKey));
    }
    private String replace(String start,String end, String key){
        int startIndex =  key.indexOf(start)+start.length();
        int endIndex = key.indexOf(end);
        String rs = key.substring(startIndex,endIndex).trim();
        rs = rs.replaceAll("\\\\n","");
        System.out.println(rs);
        return rs;
    }

    private String getPublicKey(String publicKey){
        String startKey ="-----BEGIN PUBLIC KEY-----\\n";
        String endKey = "-----END PUBLIC KEY-----\\n";
        return replace(startKey,endKey,publicKey);
    }
    private String getPrivateKey(String privateKey){
        String startKey = "-----BEGIN PRIVATE KEY-----\\n";
        String endKey = "-----END PRIVATE KEY-----\\n";
        return replace(startKey,endKey,privateKey);
    }
    private void setSecretKey(String secretKey){
        this.secretKey = secretKey;
    }
    private PublicKey string2PublicKey(String publicKeyStr) {
        KeyFactory keyFactory = null;
        PublicKey publicKey = null;
        try {
            //X509EncodedKeySpec ukeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyStr.getBytes("utf-8")));
            //keyFactory = KeyFactory.getInstance("RSA");
            //publicKey = keyFactory.generatePublic(ukeySpec);
            InputStream certstream = new ByteArrayInputStream (Base64.getDecoder().decode(publicKeyStr));
            Certificate cert = CertificateFactory.getInstance("X.509").generateCertificate(certstream);
            publicKey = cert.getPublicKey();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return publicKey;
    }

    private PrivateKey string2PrivateKey(String privateKeyStr){
        PrivateKey privateKey = null;
        try{
            PKCS8EncodedKeySpec rkeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyStr.getBytes("utf-8")));
            KeyFactory rkeyFactory = KeyFactory.getInstance("RSA");
            privateKey = rkeyFactory.generatePrivate(rkeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    private byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }
        byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }
    public static KeyUtilBuilder getBuilder(){
        return new KeyUtilBuilder();
    }
    public static class KeyUtilBuilder{
        KeyUtil instance =null;
        public KeyUtilBuilder createBuilder(){
            instance = new KeyUtil();
            return this;
        }
        private void checkInstance(){
            if(instance == null) throw new RuntimeException("Instance가 존재하지 않습니다. createBuilder 호출 먼저 부탁드립니다.");
        }
        public KeyUtilBuilder keyFile(String publicKeyFile,String privateKeyFile) throws IOException {
            checkInstance();
            instance.setKeySet(publicKeyFile,privateKeyFile);
            return this;
        }
        public KeyUtilBuilder setKeySet(String publicKey,String privateKey){
            instance.setKeySet(publicKey,privateKey);
            return this;
        }
        public KeyUtilBuilder secretKeyUsingHs256(String key){
            checkInstance();
            instance.secretKey = key;
            return this;
        }
        public KeyUtil build(){
            return instance;
        }
    }
}


