package com.songmag.tiny.service.userService.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserAddDTO {
    private long userKey;
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;
    private String addressNum;
    private boolean admin;
}
