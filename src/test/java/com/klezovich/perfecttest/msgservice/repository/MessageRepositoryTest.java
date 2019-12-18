package com.klezovich.perfecttest.msgservice.repository;

import com.klezovich.perfecttest.annotation.IntegrationTest;
import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@IntegrationTest
class MessageRepositoryTest {

    private long id = 0L;
    private String msg = "hello_world!";
    private Message message = new Message(id, msg);

    @Autowired
    private MessageRepository repository;

    @Test
    public void canSaveAndRead() {
        assertThat(repository.count(), is(0L));

        var savedMessage = repository.save(message);
        assertThat(repository.count(), is(1L));

        var readMessageOpt = repository.findById(id);
        assertThat(readMessageOpt.isPresent(), is(true));
        assertThat(readMessageOpt.get(), is(savedMessage));
    }
}