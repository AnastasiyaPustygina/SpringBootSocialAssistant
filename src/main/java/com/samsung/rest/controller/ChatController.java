package com.samsung.rest.controller;
import com.samsung.domain.Chat;
import com.samsung.domain.Organization;
import com.samsung.domain.Person;
import com.samsung.rest.dto.ChatDto;
import com.samsung.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @GetMapping("/chat") public List<ChatDto> getAllChat(){
        return chatService.getAll().stream().map(ChatDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/chat")
    public ChatDto insertChat(@RequestBody ChatDto chatDto){
        Chat chat = chatService.insert(ChatDto.toDomainObject(chatDto));
        return ChatDto.toDto(chat);
    }

    @GetMapping("/chat/{id}")
    public ChatDto getChatById(@PathVariable int id) {
        Chat chat = chatService.getById(id);
        return ChatDto.toDto(chat);
    }

    @DeleteMapping("/chat/{id}")
    public void deleteChat(@PathVariable int id){
        chatService.deleteById(id);
    }
}
