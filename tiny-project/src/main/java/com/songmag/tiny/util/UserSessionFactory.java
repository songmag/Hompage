package com.songmag.tiny.util;

import com.songmag.tiny.service.exception.MakeSessoinException;
import com.songmag.tiny.service.userService.dto.AccessDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSessionFactory {

    public static UserSession getUserSession(HttpServletRequest request, HttpSession session, AccessDTO dto) throws MakeSessoinException{
        UserSession userSession = null;
        if(!checkPrivate(session,dto)){
            throw new MakeSessoinException("0001","변조된 값으로 회원가입 했습니다.",HttpUtil.getIp(request));
        }
        return userSession;
    }
    public static boolean checkPrivate(HttpSession session, AccessDTO dto){
        return true;
    }
}
