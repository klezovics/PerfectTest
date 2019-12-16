package com.klezovich.perfecttest.msgservice.repository;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MessageRepository {

    private Map<Long, Message> map = new HashMap<>();

    public void save(Message m) {
        map.put(m.getId(),m);
    }

    public Message get(Long id) {
        return map.get(id);
    }

    public Collection<Message> getAll() {
        return map.values();
    }
}
