package com.samsung.rest.controller;


import com.samsung.domain.Chat;
import com.samsung.domain.Message;
import com.samsung.domain.Organization;
import com.samsung.domain.Person;
import com.samsung.rest.dto.MessageDto;
import com.samsung.service.ChatService;
import com.samsung.service.MessageService;
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
    public MessageDto insertMessage(@RequestParam String id,
                                    @RequestParam String whose,
                                    @RequestParam String value,
                                    @RequestParam String time,
                                    @RequestParam String chat_id,
                                    @RequestParam String strPerson,
                                    @RequestParam String strOrganization){
        String[] str_per = strPerson.split("!");
        String[] str_org = strOrganization.split("!");
        Chat chat = new Chat(Integer.parseInt(chat_id),
                new Person(Integer.parseInt(str_per[0]), str_per[1], str_per[2],
                        str_per[3], str_per[4], str_per[5], str_per[6], Integer.parseInt(str_per[7])
                ), new Organization(Integer.parseInt(str_org[0]), str_org[1], str_org[2], str_org[3],
                str_org[4], str_org[5], str_org[6], str_org[7]));
        Message message = messageService.insert(new Message(Integer.parseInt(id), whose, value, time, chat));
        System.out.println(message.toString());
        return MessageDto.toDto(message);
    }
    @PutMapping("/message/{id}")
    public MessageDto updateMessage(@PathVariable String id,
                                    @RequestParam String whose,
                                    @RequestParam String value,
                                    @RequestParam String time,
                                    @RequestParam String chat_id){
        Message message = messageService.update(Integer.parseInt(id), whose, value,
                time, Integer.parseInt(chat_id));
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
    @DeleteMapping("/chat/{id}/message")
    public void deleteMessageByChatId(@PathVariable int id) {
        messageService.deleteByChatId(id);
    }
}
