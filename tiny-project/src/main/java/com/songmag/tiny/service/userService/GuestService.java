package com.songmag.tiny.service.userService;



import com.songmag.tiny.service.UserFactory;
import com.songmag.tiny.service.exception.UserFindException;
import com.songmag.tiny.service.userService.dto.UserAddDTO;
import com.songmag.tiny.service.userService.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.IllegalFormatException;

@UserFactory(value = "guest")
public class GuestService extends ImplUserService {
    @Override
    public boolean login(UserDTO dto, HttpSession session) throws IllegalFormatException,UserFindException {
        if(!super.login(dto,session))
            return false;
        dto.setAdmin(false);
        session.setAttribute("USER_SESSION",userRepository.authUser(dto));
        return true;
    }
    @Override
    public boolean login(String userId, String userPwd,HttpSession session) throws IllegalFormatException, UserFindException {
        UserDTO dto = new UserDTO(userId,userPwd,false);
        return login(dto,session);
    }

    @Override
    @Transactional
    public void signUpUser(UserAddDTO dto) {
        dto.setAdmin(true);
    }

    @Override
    public String getUserView(String ui) {
        return null;
    }
}
