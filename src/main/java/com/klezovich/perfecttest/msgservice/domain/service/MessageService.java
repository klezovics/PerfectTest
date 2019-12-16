package com.klezovich.perfecttest.msgservice.domain.service;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public boolean save(Message m) {
        repository.save(m);
        return true;
    }

    public Message get(Long id) {
        return repository.get(id);
    }

    public Collection<Message> getAll() {
        return repository.getAll();
    }
}
