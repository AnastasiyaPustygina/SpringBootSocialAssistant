package com.samsung.service;


import com.samsung.domain.Chat;
import com.samsung.domain.Message;

import java.util.List;

public interface MessageService {

    Message insert(Message message);
    List<Message> getByChatId(int id);
    List<Message> getAll();
    void deleteById(int id);
    Message update(int id, String whose, String value, String time, int chat_id);
    void deleteByChatId(int id);
}
