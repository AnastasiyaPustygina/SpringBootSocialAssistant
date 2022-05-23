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
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Message update(int id, String whose, String value, String time, int chat_id) {
        Chat chat = chatRepository.findById(chat_id);
        Message message = Message.builder().id(id).whose(whose).value(value).time(time).chat(chat).build();
        return messageRepository.save(message);
    }

    @Override
    public void deleteByChatId(int id) {
        messageRepository.deleteByChatId(id);
    }
}
