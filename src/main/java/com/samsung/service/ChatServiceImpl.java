package com.samsung.service;

import com.samsung.domain.Chat;
import com.samsung.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{

    private final ChatRepository chatRepository;

    @Override
    public List<Chat> getAll() {
        return chatRepository.findAll();
    }

    @Override
    public Chat insert(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Chat getById(int id) {
        return chatRepository.getById(id);
    }

    @Override
    public Chat getByPersonIdAndOrganizationId(int person_id, int organization_id) {
        Chat chat = chatRepository.findByPersonIdAndOrganizationId(person_id, organization_id);
        return chat;

    }

    @Override
    public void deleteById(int id) {
        chatRepository.deleteById(id);
    }
}
