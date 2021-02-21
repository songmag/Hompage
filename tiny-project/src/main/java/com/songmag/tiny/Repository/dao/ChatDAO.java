package com.songmag.tiny.Repository.dao;

import com.songmag.tiny.Repository.vo.ChatMessageVO;
import com.songmag.tiny.Repository.vo.ChatRoomVO;

import java.util.List;
import java.util.Optional;

public interface ChatDAO {
    Optional<ChatRoomVO> getRooms(String userId);
    Optional<List<ChatMessageVO>> getMessageInRoom(String chatRoom);
}
