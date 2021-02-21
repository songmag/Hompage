package com.songmag.tiny.service.userService;

import com.songmag.tiny.Repository.UserRepository;
import com.songmag.tiny.service.UserFactory;
import com.songmag.tiny.service.exception.TransactionalException;
import com.songmag.tiny.service.exception.UserFindException;
import com.songmag.tiny.service.userService.dto.UserAddDTO;
import com.songmag.tiny.service.userService.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.IllegalFormatException;

@UserFactory(value = "admin")
public class AdminService extends ImplUserService{

    @Override
    public void signUpUser(UserAddDTO dto) {
        dto.setAdmin(true);
        super.signUpUser(dto);
    }

    @Override
    public String getUserView(String ui) {
        return null;
    }

    @Override
    public boolean login(UserDTO dto, HttpSession session) throws IllegalFormatException, UserFindException {
        if(!super.login(dto,session)){
            return false;
        }
        dto.setAdmin(true);
        session.setAttribute("USER_SESSION",userRepository.authUser(dto));
        return true;
    }

    @Override
    public boolean login(String userId, String userPwd, HttpSession session) throws IllegalFormatException, UserFindException {
        UserDTO dto = new UserDTO(userId,userPwd,true);
        return login(dto,session);
    }
}
