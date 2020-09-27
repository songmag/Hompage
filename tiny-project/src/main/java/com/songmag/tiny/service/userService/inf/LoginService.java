package com.songmag.tiny.service.userService.inf;

import com.songmag.tiny.service.userService.dto.UserDTO;

import java.util.IllegalFormatException;

public interface LoginService {
    boolean login(UserDTO dto) throws IllegalFormatException;
    boolean login(String userId, String userPwd) throws IllegalFormatException;
}
