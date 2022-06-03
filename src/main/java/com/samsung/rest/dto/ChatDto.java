package com.samsung.rest.dto;

import com.samsung.domain.Chat;
import com.samsung.repository.OrganizationRepository;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ChatDto {
    private int id;
    private PersonDto personDto;
    private OrganizationDto organizationDto;

    public static com.samsung.rest.dto.ChatDto toDto(Chat chat) {

        return new com.samsung.rest.dto.ChatDto(chat.getId(),
                PersonDto.toDto(chat.getPerson()), OrganizationDto.toDto(chat.getOrganization()));
    }
    public static Chat toDomainObject(ChatDto chatDto){

        return new Chat(chatDto.getId(), PersonDto.toDomainObject(chatDto.getPersonDto()),
                OrganizationDto.toDomainObject(chatDto.getOrganizationDto()));
    }

}
