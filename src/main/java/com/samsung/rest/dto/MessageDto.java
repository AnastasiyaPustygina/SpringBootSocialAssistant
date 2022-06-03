package com.samsung.rest.dto;

import com.samsung.domain.Chat;
import com.samsung.domain.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MessageDto {
    private int id;
    private String whose, value, time;
    private ChatDto chatDto;


    public static com.samsung.rest.dto.MessageDto toDto(Message message) {
        return new com.samsung.rest.dto.MessageDto(message.getId(),
                message.getWhose(), message.getValue(), message.getTime(),
                ChatDto.toDto(message.getChat()));

    }
    public static Message toDomainObject(MessageDto messageDto){

        return new Message(messageDto.getId(), messageDto.getWhose(),
                messageDto.getValue(), messageDto.getTime(), ChatDto.toDomainObject(
                        messageDto.getChatDto()));
    }

}
