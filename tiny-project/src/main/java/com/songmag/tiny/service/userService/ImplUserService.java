package com.songmag.tiny.service.userService;

import com.songmag.tiny.Repository.UserRepository;
import com.songmag.tiny.service.exception.TransactionalException;
import com.songmag.tiny.service.exception.UserFindException;
import com.songmag.tiny.service.userService.dto.UserAddDTO;
import com.songmag.tiny.service.userService.dto.UserDTO;
import com.songmag.tiny.service.userService.inf.UserService;
import com.songmag.tiny.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.IllegalFormatException;
public abstract class ImplUserService implements UserService {
    @Autowired
    protected UserRepository userRepository;
    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public void signUpUser(UserAddDTO dto){
        userRepository.addUser(dto);
    }
    @Override
    public boolean login(UserDTO dto, HttpSession session) throws IllegalFormatException, UserFindException {
        if(dto.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public boolean login(String userId, String userPwd,HttpSession session) throws IllegalFormatException, UserFindException {
        return !StringUtil.isBlank(userId) && !StringUtil.isBlank(userPwd);
    }
    @Override
    public abstract String getUserView(String ui);
}
