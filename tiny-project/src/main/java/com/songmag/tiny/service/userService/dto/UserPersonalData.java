package com.songmag.tiny.service.userService.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserPersonalData {
    private String name;
    private String phoneNumber;
    private String address;
    private String addressNum;
}
