package com.songmag.tiny.service;

import com.songmag.tiny.service.userService.inf.UserService;
import com.songmag.tiny.service.exception.NullFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceFactory {
    @Autowired
    UserServiceContainer container;

    public UserService service(String value) throws NullFindService{
        UserService userService = (UserService) container.userServices.get(value);
        if(userService != null){
            return userService;
        }
        throw new NullFindService(value,value);
    }

}
