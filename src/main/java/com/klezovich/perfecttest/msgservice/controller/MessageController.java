package com.klezovich.perfecttest.msgservice.controller;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.NoSuchElementException;
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
        return collectionToDto(service.getAll());
    }

    @GetMapping("/get/{id}")
    public MessageDto get( @PathVariable("id") Long id) {
        return mapper.toMessageDto(service.get(id));
    }

    @PostMapping("/save")
    public void save(@RequestBody MessageDto dto) {
        service.save(mapper.toMessage(dto));
    }

    private Collection<MessageDto> collectionToDto(Iterable<Message> messages) {
        return StreamSupport.stream(messages.spliterator(),false).map(mapper::toMessageDto).collect(toList());
    }
}
