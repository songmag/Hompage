package com.songmag.tiny.service.userService;

import com.songmag.tiny.service.userService.dto.UserDTO;
import com.songmag.tiny.service.userService.inf.UserService;
import com.songmag.tiny.util.StringUtil;

import java.util.IllegalFormatException;

public abstract class ImplUserService implements UserService {

    @Override
    public boolean login(UserDTO dto) throws IllegalFormatException {
        if(StringUtil.isBlank(dto.getUserId()) || StringUtil.isBlank(dto.getUserPwd())){
            return false;
        }
        return true;
    }
    @Override
    public boolean login(String userId, String userPwd) throws IllegalFormatException {
        if(StringUtil.isBlank(userId) || StringUtil.isBlank(userPwd)){
            return false;
        }
        return true;
    }


    @Override
    public abstract String getUserView(String ui);
}
