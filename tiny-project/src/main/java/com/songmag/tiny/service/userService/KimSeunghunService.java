package com.songmag.tiny.service.userService;

import com.songmag.tiny.service.UserFactory;
import com.songmag.tiny.service.userService.dto.UserDTO;

import java.util.IllegalFormatException;

@UserFactory("kimSeunghun")
public class KimSeunghunService extends ImplUserService {

    @Override
    public boolean login(UserDTO dto) throws IllegalFormatException {
        if(!super.login(dto)) return false;
        return true;
    }

    @Override
    public boolean login(String userId, String userPwd) throws IllegalFormatException {
        if(!super.login(userId, userPwd)) return false;
        return true;
    }

    @Override
    public String getUserView(String ui) {
        return null;
    }
}
