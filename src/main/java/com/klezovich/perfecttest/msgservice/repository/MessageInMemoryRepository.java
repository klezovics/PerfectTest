package com.klezovich.perfecttest.msgservice.repository;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class MessageInMemoryRepository implements CrudRepository<Message,Long> {

    private Map<Long, Message> map = new HashMap<>();

    public Message save(Message m) {
        map.put(m.getId(), m);
        return m;
    }

    public Optional<Message> findById(Long id) {
        var value = map.get(id);
        if (null == value) {
            return Optional.empty();
        }
        return Optional.of(value);
    }

    @Override
    public <S extends Message> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        noSuchMethod();
        return false;
    }

    public Collection<Message> findAll() {
        return map.values();
    }

    @Override
    public Iterable<Message> findAllById(Iterable<Long> iterable) {
        noSuchMethod();
        return null;
    }

    @Override
    public long count() {
        noSuchMethod();
        return 0L;
    }

    @Override
    public void deleteById(Long aLong) {
        noSuchMethod();
    }

    @Override
    public void delete(Message message) {
        noSuchMethod();
    }

    @Override
    public void deleteAll(Iterable<? extends Message> iterable) {
        noSuchMethod();
    }

    @Override
    public void deleteAll() {
       noSuchMethod();
    }

    private void noSuchMethod() {
        throw new RuntimeException("No such method");
    }
}
