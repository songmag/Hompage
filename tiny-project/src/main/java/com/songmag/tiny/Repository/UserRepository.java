package com.songmag.tiny.Repository;
import com.songmag.tiny.service.exception.UserFindException;
import com.songmag.tiny.service.userService.dto.UserAddDTO;
import com.songmag.tiny.service.userService.dto.UserDTO;
import com.songmag.tiny.service.userService.dto.UserSession;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    UserSession authUser(UserDTO dto) throws UserFindException;
    boolean addUser(UserAddDTO dto);

}
