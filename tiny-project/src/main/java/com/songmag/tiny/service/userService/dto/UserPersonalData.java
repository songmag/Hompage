package com.songmag.tiny.service.userService.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserPersonalData {
    private String name;
    private String email;
    private String phoneNumber;
    private String location;
}
