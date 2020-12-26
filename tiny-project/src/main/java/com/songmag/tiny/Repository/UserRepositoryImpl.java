package com.songmag.tiny.Repository;

import com.songmag.tiny.Repository.dao.UserDAO;
import com.songmag.tiny.service.exception.UserFindException;
import com.songmag.tiny.service.userService.dto.UserAddDTO;
import com.songmag.tiny.service.userService.dto.UserDTO;
import com.songmag.tiny.service.userService.dto.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "UserRepository")
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    UserDAO userDAO;

    @Override
    public UserSession authUser(UserDTO dto) throws UserFindException {
        Optional<UserSession> userSession = null;
        userSession = userDAO.authUser(dto);
        return userSession.orElseThrow(()-> new UserFindException(dto.getUserId()));
    }
    @Override
    public boolean addUser(UserAddDTO dto) {
        userDAO.addUserId(dto);
        userDAO.addUserInfo(dto);
        return false;
    }
}
