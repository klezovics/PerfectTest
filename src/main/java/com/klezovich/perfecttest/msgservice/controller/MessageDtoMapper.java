package com.klezovich.perfecttest.msgservice.controller;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageDtoMapper {

    Message toMessage(MessageDto dto) {
        return new Message(dto.getId(), dto.getMessage());
    }

    MessageDto toMessageDto(Message message) {
        return new MessageDto(message.getId(), message.getMessage());
    }
}
