package com.samsung.rest.controller;


import com.samsung.domain.Chat;
import com.samsung.domain.Message;
import com.samsung.domain.Organization;
import com.samsung.domain.Person;
import com.samsung.rest.dto.ChatDto;
import com.samsung.rest.dto.MessageDto;
import com.samsung.rest.dto.OrganizationDto;
import com.samsung.rest.dto.PersonDto;
import com.samsung.service.ChatService;
import com.samsung.service.MessageService;
import liquibase.pro.packaged.S;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/message")
    public List<MessageDto> getAllMessage() {
        return messageService
                .getAll()
                .stream()
                .map(MessageDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/message")
    public MessageDto insertMessage(@RequestBody MessageDto messageDto){
        Message message = messageService.insert(MessageDto.toDomainObject(messageDto));
        return MessageDto.toDto(message);
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id){
        messageService.deleteById(id);
    }
    @GetMapping("/chat/{id}/message")
    public List<MessageDto> getMessageByChatId(@PathVariable int id) {
        return messageService
                .getByChatId(id)
                .stream()
                .map(MessageDto::toDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/message/{id}")
    public MessageDto getMessageById(@PathVariable int id) {
        Message message = messageService.getById(id);
        return MessageDto.toDto(message);
    }
    @GetMapping("/message/size")
    public int getMessageSize() {
        return messageService.getMsgSize();
    }
    @DeleteMapping("/chat/{id}/message")
    public void deleteMessageByChatId(@PathVariable int id) {
        messageService.deleteByChatId(id);
    }
}
