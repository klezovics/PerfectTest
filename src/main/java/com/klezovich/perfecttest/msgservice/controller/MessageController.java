package com.klezovich.perfecttest.msgservice.controller;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@RestController("/")
public class MessageController {

    private final MessageDtoMapper mapper;
    private final MessageService service;

    @Autowired
    public MessageController(MessageDtoMapper mapper, MessageService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/get")
    public Collection<MessageDto> getAll() {
        return toDto(service.getAll());
    }

    @PostMapping("/save")
    public void save(@RequestBody MessageDto dto) {
        service.save(mapper.toMessage(dto));
    }

    private Collection<MessageDto> toDto(Collection<Message> messages) {
        return messages.stream().map(mapper::toMessageDto).collect(toList());
    }
}
