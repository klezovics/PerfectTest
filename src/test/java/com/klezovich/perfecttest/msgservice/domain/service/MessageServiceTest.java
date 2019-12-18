package com.klezovich.perfecttest.msgservice.domain.service;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.repository.MessageInMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MessageServiceTest {

    private CrudRepository<Message, Long> repository;
    private MessageService service;
    private Message message;

    @BeforeEach
    public void setUp() {
        repository = mock(MessageInMemoryRepository.class);
        service = new MessageService(repository);
        message = new Message(1L, "Hello");
    }

    @Test
    public void testMessageSuccessfullySaved() {
        when(repository.save(message)).thenReturn(message);
        service.save(message);

        verify(repository).save(message);
    }

    @Test
    void testSingleMessageCanBeRead() {
        when(repository.findById(1L)).thenReturn(Optional.of(message));

        var msg = service.get(1L);
        assertThat(message, is(msg));
    }

    @Test
    void testMultipleMessagesCanBeRead() {
        when(repository.findAll()).thenReturn(List.of(message));

        var msgs = repository.findAll();
        assertThat(StreamSupport.stream(msgs.spliterator(), false)
            .collect(Collectors.toList()), hasSize(1));
        assertThat(msgs, hasItem(message));
    }
}