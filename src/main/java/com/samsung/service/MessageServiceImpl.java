package com.samsung.service;

import com.samsung.domain.Chat;
import com.samsung.domain.Message;
import com.samsung.repository.ChatRepository;
import com.samsung.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;

    @Override
    public Message insert(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getByChatId(int id) {
        return messageRepository.findByChatId(id);
    }

    @Override
    public Message getById(int id) {
        return messageRepository.getById(id);
    }

    @Override
    public int getMsgSize() {
        return messageRepository.findAll().size();
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }


    @Override
    public void deleteByChatId(int id) {
        messageRepository.deleteByChatId(id);
    }
}
