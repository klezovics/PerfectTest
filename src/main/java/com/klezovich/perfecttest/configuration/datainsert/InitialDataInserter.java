package com.klezovich.perfecttest.configuration.datainsert;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "initial.data.import")
public class InitialDataInserter implements CommandLineRunner {

    private final CrudRepository<Message, Long> repository;

    @Autowired
    public InitialDataInserter(CrudRepository<Message, Long> repository) {this.repository = repository;}

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Message(0L,"Initial message"));
    }
}
