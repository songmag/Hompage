package com.songmag.tiny.util;

import com.songmag.tiny.service.userService.dto.UserAccessTocken;

public class UserSession {

    String accessTocken;
    String userId;
    String privateKey;



    public boolean expireCheck(UserAccessTocken tocken) {
        return true;
    }
}
