package com.klezovich.perfecttest.msgservice.repository;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Repository
public class MessageRepository {

    private Map<Long, Message> map = new HashMap<>();

    public void save(Message m) {
        map.put(m.getId(), m);
    }

    public Message get(Long id) {
        var value = map.get(id);
        if (null == value) {
            throw new NoSuchElementException("id:" + id);
        }
        return value;
    }

    public Collection<Message> getAll() {
        return map.values();
    }
}
