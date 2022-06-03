package com.samsung.service;


import com.samsung.domain.Chat;
import com.samsung.domain.Message;

import java.util.List;

public interface MessageService {

    Message insert(Message message);
    List<Message> getByChatId(int id);
    List<Message> getAll();
    Message getById(int id);
    int getMsgSize();
    void deleteById(int id);
    void deleteByChatId(int id);
}
