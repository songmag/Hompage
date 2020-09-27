package com.songmag.tiny.service.userService.dto;

import org.springframework.beans.factory.annotation.Autowired;


public class UserSession {
    private String userId;
    private UserPersonalData data;

    @Autowired
    UserRepository userRepository;

    public UserSession(String userId)
    {
           this.userId = userId;

           userRepository.get();
    }
}
