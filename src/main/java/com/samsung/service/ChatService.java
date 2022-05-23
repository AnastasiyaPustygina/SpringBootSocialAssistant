package com.samsung.service;


import com.samsung.domain.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> getAll();
    Chat insert(Chat chat);
    Chat getById(int id);
    Chat getByPersonIdAndOrganizationId(int person_id, int organization_id);
    void deleteById(int id);
}
