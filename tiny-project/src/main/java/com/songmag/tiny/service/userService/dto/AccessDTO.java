package com.songmag.tiny.service.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccessDTO {
    private String aesSecret;
    private String aesPublicKey;
}
