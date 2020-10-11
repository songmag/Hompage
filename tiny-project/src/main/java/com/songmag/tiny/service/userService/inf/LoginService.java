package com.songmag.tiny.service.userService.inf;

import com.songmag.tiny.service.exception.UserFindException;
import com.songmag.tiny.service.userService.dto.UserDTO;
import org.apache.catalina.Session;

import javax.servlet.http.HttpSession;
import java.util.IllegalFormatException;

public interface LoginService {
    boolean login(UserDTO dto, HttpSession session) throws IllegalFormatException,UserFindException;
    boolean login(String userId, String userPwd,HttpSession session) throws IllegalFormatException, UserFindException;
}
