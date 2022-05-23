package com.samsung.rest.controller;
import com.samsung.domain.Chat;
import com.samsung.domain.Organization;
import com.samsung.domain.Person;
import com.samsung.rest.dto.ChatDto;
import com.samsung.rest.dto.OrganizationDto;
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
                              @RequestParam String strPerson,
                              @RequestParam String strOrganization){
        String[] str_per = strPerson.split("!");
        String[] str_org = strOrganization.split("!");
        Chat chat = chatService.insert(new Chat(Integer.parseInt(id),
                new Person(Integer.parseInt(str_per[0]), str_per[1], str_per[2],
                        str_per[3], str_per[4], str_per[5], str_per[6], Integer.parseInt(str_per[7])
                ), new Organization(Integer.parseInt(str_org[0]), str_org[1], str_org[2], str_org[3],
                str_org[4], str_org[5], str_org[6], str_org[7])));
        return ChatDto.toDto(chat);
    }
    @GetMapping("/chat/{id}")
    public ChatDto getChatById(@PathVariable int id) {
        Chat chat = chatService.getById(id);
        return ChatDto.toDto(chat);
    }
//    @GetMapping("/chat/{per_id}/{org_id}")
//    public ChatDto getChatByPersonIdAndOrganizationId(@PathVariable int per_id,
//                                                      @PathVariable int org_id) {
//        Chat chat = chatService.getByPersonIdAndOrganizationId(per_id, org_id);
//        return ChatDto.toDto(chat);
//    }

    @DeleteMapping("/chat/{id}")
    public void deleteChat(@PathVariable int id){
        chatService.deleteById(id);
    }
}
