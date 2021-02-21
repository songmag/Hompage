package com.songmag.tiny.service;

import com.songmag.tiny.ContextClass;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class UserServiceContainer{
    Map<String, Object> userServices;
    private UserServiceContainer(){}
    @PostConstruct
    public void init(){
        userServices = ContextClass.context
                .getBeansWithAnnotation(UserFactory.class);
    }

}
