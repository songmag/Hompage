package com.songmag.tiny.Repository.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatMessageVO {
    public String userId;
    public String message;
}
