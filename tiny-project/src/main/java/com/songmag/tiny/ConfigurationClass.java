package com.songmag.tiny;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.net.URI;

@Configuration
public class ConfigurationClass  {

    @Bean
    public Gson getGson(){
        return new Gson();
    }
    /*
    @Bean(value = "userNotFindExceptionHtml")
    @Scope(value = "application")
    public StringBuilder userNotFindExceptionHtml(){
        StringBuilder builder = new StringBuilder();
        File file = new File(URI.create("classpath:/static/html/UserNotFindException.html"));
        return builder;
    }*/
}
