package com.songmag.tiny.service.google;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleToken {
    String access_token;
    long expires_in;
    String token_type;
}
