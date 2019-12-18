package com.klezovich.perfecttest.msgservice.domain.service;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final CrudRepository<Message,Long> repository;

    @Autowired
    public MessageService(CrudRepository<Message,Long> repository) {
        this.repository = repository;
    }

    public boolean save(Message m) {
        repository.save(m);
        return true;
    }

    public Message get(Long id) {
        var message = repository.findById(id);
        if(message.isPresent()) {
            return message.get();
        }

        throw new RuntimeException("Element not found");
    }

    public Iterable<Message> getAll() {
        return repository.findAll();
    }
}
