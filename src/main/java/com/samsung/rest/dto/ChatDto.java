package com.samsung.rest.dto;
import com.samsung.domain.Chat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
