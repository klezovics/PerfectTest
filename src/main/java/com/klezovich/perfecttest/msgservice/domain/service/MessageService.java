package com.klezovich.perfecttest.msgservice.domain.service;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public Optional<Message> get(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Collection<Message> getAll() {
        return toCollection(repository.findAll());
    }

    private Collection<Message> toCollection( Iterable<Message> messages) {
        return StreamSupport.stream(messages.spliterator(), false)
            .collect(Collectors.toList());
    }
}
