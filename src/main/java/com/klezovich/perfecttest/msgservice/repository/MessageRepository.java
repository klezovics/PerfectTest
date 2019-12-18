package com.klezovich.perfecttest.msgservice.repository;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public interface MessageRepository extends CrudRepository<Message,Long> {
}
