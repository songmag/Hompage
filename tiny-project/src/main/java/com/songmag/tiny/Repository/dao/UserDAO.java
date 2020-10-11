package com.songmag.tiny.Repository.dao;

import com.songmag.tiny.service.userService.dto.UserDTO;
import com.songmag.tiny.service.userService.dto.UserSession;

import java.util.Optional;


public interface UserDAO  {
    Optional<UserSession> authUser(UserDTO dto);
}
