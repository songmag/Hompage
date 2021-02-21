package com.songmag.tiny.util;

import com.songmag.tiny.service.exception.MakeSessoinException;
import com.songmag.tiny.service.userService.dto.AccessDTO;
import com.songmag.tiny.service.userService.dto.UserAccessTocken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {
    public static UserSession getSession(HttpServletRequest request,HttpSession session, UserAccessTocken tocken){
        UserSession userSession = (UserSession) session.getAttribute("UserSession");
        if(!userSession.expireCheck(tocken)){
            return null;
        }
        return userSession;
    }
    public static UserSession getSession(HttpServletRequest request, HttpSession session, AccessDTO dto){
        UserSession userSession =null;
        try {
            userSession = UserSessionFactory.getUserSession(request,session, dto);
        }catch(MakeSessoinException e){
            e.getMessage();
        }
        return userSession;
    }
}
