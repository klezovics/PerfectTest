package com.klezovich.perfecttest.msgservice.controller;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageDtoMapper {

    public Message toMessage(MessageDto dto) {
        return new Message(dto.getId(), dto.getMessage());
    }

    public MessageDto toMessageDto(Message message) {
        return new MessageDto(message.getId(), message.getMessage());
    }
}
