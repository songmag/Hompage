package com.songmag.tiny.service.userService.dto;

import com.songmag.tiny.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
    private String userId;
    private String userPwd;
    private boolean admin;

    public boolean isEmpty(){
        if(StringUtil.isBlank(userId) || StringUtil.isBlank(userPwd)){
            return true;
        }
        return false;
    }
}
