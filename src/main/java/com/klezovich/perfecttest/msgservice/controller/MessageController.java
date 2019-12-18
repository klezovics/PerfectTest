package com.klezovich.perfecttest.msgservice.controller;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.StreamSupport;

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
        return iterableToDto(service.getAll());
    }

    @GetMapping("/get/{id}")
    public MessageDto get( @PathVariable("id") Long id) {
        return mapper.toMessageDto(service.get(id));
    }

    @PostMapping("/save")
    public void save(@RequestBody MessageDto dto) {
        service.save(mapper.toMessage(dto));
    }

    private Collection<MessageDto> iterableToDto(Iterable<Message> messages) {
        return StreamSupport.stream(messages.spliterator(),false).map(mapper::toMessageDto).collect(toList());
    }
}
