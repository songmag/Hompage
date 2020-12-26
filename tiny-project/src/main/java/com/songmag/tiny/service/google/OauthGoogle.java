package com.songmag.tiny.service.google;

import com.google.gson.Gson;
import com.songmag.tiny.util.jwt.HSJwtUtil;
import com.songmag.tiny.util.jwt.JwtUtil;
import com.songmag.tiny.util.jwt.KeyUtil;
import com.songmag.tiny.util.jwt.RsaJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

/**
 *  TODO
 *
 *  처리해야함. jwt token 만들어서 처리
 *
 */
@Component
public class OauthGoogle {
    private static final String url ="https://accounts.google.com/o/oauth2/v2/auth";
    private static final String CLIENTKEY ="AIzaSyAftx6aPIH1rHPRuktxy3V_rlO9HdZkiSg";
    private static final String CLIENTID = "ktworks";
    private static final String publicKey = "-----BEGIN PUBLIC KEY-----\\nMIIC/DCCAeSgAwIBAgIIW4K1pRxZEoYwDQYJKoZIhvcNAQEFBQAwIDEeMBwGA1UE\\nAxMVMTE0MjkxNTgzNTAxMzI1NzA3MDU1MCAXDTIwMTAyNTExMTU0MVoYDzk5OTkx\\nMjMxMjM1OTU5WjAgMR4wHAYDVQQDExUxMTQyOTE1ODM1MDEzMjU3MDcwNTUwggEi\\nMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCyfNzwr6gnhQiTwGNGHR9C6fCS\\na+1rKPLFw7adtRxJaT28kXosYQJWbis+KyyZHjJbvV+0p88BLmVKaoBK59Pf8fhS\\nG0lIY097O3d+LmF+HI7WAKADV5jBMvJJcjnRpgAHzK7nTcddVbHJhhifsDqZ8Ie5\\ncUITBpEXKqXVSLF85NXg+4TUP3IrYl5NQssFH9hspXG/mbClkBDOEIZEHksNcSZX\\ns2quOcLaNzOe6XpyGm4O1PyUM48xS6j8sKh+Xv+5bTEy3tuBfSygGEr5VJaZwSGO\\nugWtpO/hOWWR4Rcs/8w6RCZ/pxPawYcQXtuEKMiGEXJdgr/TE5msDVjQhuibAgMB\\nAAGjODA2MAwGA1UdEwEB/wQCMAAwDgYDVR0PAQH/BAQDAgeAMBYGA1UdJQEB/wQM\\nMAoGCCsGAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4IBAQBVNXm7ulDYe9KyAcr35RUo\\nvzkBwfVzknefBx1byza3he5Y8PJh8ziHF/BZpO++ijqwmgYhfF3mM59L2tPugweZ\\nzAfXwZIc3eEcBWS44405Rr7w/TpCw0q7mTjDymFJ1p4aPMkw2JeJyvGrhExuAwT7\\nLIvWp1jBLs1L9zrLCFeJI+1gjcoGXwKn+JV4V1TVllPVu+Yfj22pvx7WZhk/lFgh\\nUXr2g+pZKrwfj6EqV1dOry1ZFGW9KDFdzf/SQ2jjCuCqvvQUGGm1SiFblIbzg5pM\\nfClB/eBKeUIhUTu1XNHBXJ6O3PBhJ54US6l5SeZgnQagX65OD0GkkI+JewROfiKI\\n-----END PUBLIC KEY-----\\n";
    private static final String privateKey = "-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCyfNzwr6gnhQiT\\nwGNGHR9C6fCSa+1rKPLFw7adtRxJaT28kXosYQJWbis+KyyZHjJbvV+0p88BLmVK\\naoBK59Pf8fhSG0lIY097O3d+LmF+HI7WAKADV5jBMvJJcjnRpgAHzK7nTcddVbHJ\\nhhifsDqZ8Ie5cUITBpEXKqXVSLF85NXg+4TUP3IrYl5NQssFH9hspXG/mbClkBDO\\nEIZEHksNcSZXs2quOcLaNzOe6XpyGm4O1PyUM48xS6j8sKh+Xv+5bTEy3tuBfSyg\\nGEr5VJaZwSGOugWtpO/hOWWR4Rcs/8w6RCZ/pxPawYcQXtuEKMiGEXJdgr/TE5ms\\nDVjQhuibAgMBAAECggEAAV7ji6+gTzspP2xVE0cKh7G9b9GHW/EIK8wQdhzNcBXF\\npRkC5nNYfBVR8gaNL2cqy4AdS4k/61FY8shnXl2rDrIluN3qcVHPsg31kzunnXQI\\nlBrpreI5fenhE6lsnsyW0rFmMx2G9XcH1m5Jzcl3KqEiZwX/Wy19yaKW7fttUQ6X\\nh9oCWvBcBqtCemIVxJ+7nPEGcinRKSVwAD7FzWCQl/7WzhHtzZI9UmO7iJkIPvqw\\naNzpfsiUt93GMbxBeBDiDRnfBUae7fqu/W1Hl5yJi3HddFvB1WN9dSkelk6u6tse\\nxmzRIu9zo65To/lICJDSo1v9AhpiBRqOiyOU8rYx9QKBgQDf1IDhKsUZ6C7YDk1Z\\nrPYMNGey/Wn8aUERX75p9FNjQqQb+KwB80oGKyn3OAeQLq84S2diymyQu4IEi1ju\\nyLoiBVcqFE1FI3fCMP0MER94pTHBtztx5mT+A/Rl1tJM4rrQCObVnQvx6DwSLo9l\\no/px+SMYKI0BhxXl0VVMKgQHJQKBgQDMJA4hwK66FNLqjMfeWMjVOv8uFrBYNs35\\n6Yhtyp4+EKnf4ym5TA3UuSQNS5tubP4oZgmULZtGsG3pFFa+1JQMewODPmbBRTVj\\nJLt+br15EnKZ6ey/OSrilZCixFSeC2bi0kD4DR6VqGLuC8IsylpuiOHYKwoya6/i\\n+dM3/fUEvwKBgFBfcSvpfL8xxWhlslbKKcv2IWp/Xsh5TxkbBTfsuOjCrEUzBSjq\\nIKGYbEhOgUC/0sFnKieqQlOyURyqoPOVdmjy+/qrMZfrBXzgtGzZ1TAwOW6zChB7\\nR7aC2waangdnvucm2yTHcNubpb5to6Y+vJaifHyXSxLKXA2bHoLr72hVAoGBALzc\\nvpZLhVty2I9XH7J9wZBEvMEPDKcQTQ/hFu88fZo+IGuZ5ogf7MvZXZlPUcWf4KPP\\ngx0r9HQ51fXFc1upoC7LwDw0ByzXssS+vxgBrBnPD2eGHBnt8dcfOGjd6sstEUrX\\n6nOS77DV0HEbP9HghDmvOgKcDxsGtfrv1pH+yihRAoGBAMTdOAZrGPHo39Br3rRu\\n8rLaVeZjnoz8ZobhRRavy45n9tN7G7cCABt8B+qncwuu+gbKQHhepeDm95+NhgR/\\nuDGb19kK8+u8OYs47cy46x+9lONeXLSwnl9DIVsXdhsJeyIfhBUXDm9+QGSuvT3/\\nUXsLJJpTo3MCePwu7fzIiEoN\\n-----END PRIVATE KEY-----\\n";
    private JwtUtil util;

    @PostConstruct
    public void initMethod(){
        KeyUtil.KeyUtilBuilder builder = KeyUtil.getBuilder();
        KeyUtil keyUtil =builder.createBuilder().setKeySet(publicKey,privateKey).build();
        util = new RsaJwtUtil(keyUtil);
    }

    public String getToken(String userId, String pwd)
    {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate template = builder.rootUri(url).build();
        String jwtToken;
        return "";
    }
    public String getJwtToken() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Map<String,Object> object = new HashMap<String,Object>();
        object.put("iss","tester@ktworks.iam.gserviceaccount.com");
        object.put("scope","https://www.googleapis.com/auth/calendar");
        object.put("aud","https://oauth2.googleapis.com/token");
        return util.getJwt(object,"RS256");
    }
}
