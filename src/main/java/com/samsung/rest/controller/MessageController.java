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
    public MessageDto insertMessage(@RequestParam String id,
                                    @RequestParam String whose,
                                    @RequestParam String value,
                                    @RequestParam String time,
                                    @RequestParam String idChat,
                                    @RequestParam String idPerson,
                                    @RequestParam String namePerson,
                                    @RequestParam String telephonePerson,
                                    @RequestParam String emailPerson,
                                    @RequestParam String cityPerson,
                                    @RequestParam String photoPerson,
                                    @RequestParam String dateOfBirthPerson,
                                    @RequestParam String agePerson,
                                    @RequestParam String idOrganization,
                                    @RequestParam String nameOrganization,
                                    @RequestParam String typeOrganization,
                                    @RequestParam String photoOrganization,
                                    @RequestParam String descriptionOrganization,
                                    @RequestParam String addressOrganization,
                                    @RequestParam String needsOrganization,
                                    @RequestParam String linkToWebsiteOrganization){
        Chat chat = new Chat(Integer.parseInt(idChat),
                new Person(Integer.parseInt(idPerson), namePerson, telephonePerson, emailPerson,
                        cityPerson, photoPerson, dateOfBirthPerson, Integer.parseInt(agePerson)),
                new Organization(Integer.parseInt(idOrganization), nameOrganization, typeOrganization,
                        photoOrganization, descriptionOrganization, addressOrganization, needsOrganization,
                        linkToWebsiteOrganization));
        Message message = messageService.insert(new Message(Integer.parseInt(id), whose, value, time, chat));
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
