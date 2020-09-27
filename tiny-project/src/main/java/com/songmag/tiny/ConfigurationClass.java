package com.songmag.tiny;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass  {

    @Bean
    public Gson getGson(){
        return new Gson();
    }
}
