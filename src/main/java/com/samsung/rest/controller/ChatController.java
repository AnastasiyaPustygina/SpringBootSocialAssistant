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
    public ChatDto insertChat(@RequestParam String id,
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
        Chat chat = chatService.insert(new Chat(Integer.parseInt(id),
                new Person(Integer.parseInt(idPerson), namePerson, telephonePerson, emailPerson,
                        cityPerson, photoPerson, dateOfBirthPerson, Integer.parseInt(agePerson)),
                new Organization(Integer.parseInt(idOrganization), nameOrganization, typeOrganization,
                        photoOrganization, descriptionOrganization, addressOrganization, needsOrganization,
                        linkToWebsiteOrganization)));
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
