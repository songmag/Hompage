package com.songmag.tiny.service.userService.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSession {
    private String emailId;
    private Timestamp registDate;
    private UserPersonalData data;
}