package com.klezovich.perfecttest.msgservice.domain.service;

import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;


class MessageServiceTest {

    private MessageRepository repository;
    private MessageService service;
    private Message message;

    @BeforeEach
    public void setUp() {
        repository = mock(MessageRepository.class);
        service = new MessageService(repository);
        message = new Message(1L, "Hello");
    }

    @Test
    public void testMessageSuccessfullySaved() {
        doNothing().when(repository).save(message);
        service.save(message);

        verify(repository).save(message);
    }

    @Test
    void testSingleMessageCanBeRead() {
        when(repository.findById(1L)).thenReturn(message);

        var msg = service.get(1L);
        assertThat(message, is(msg));
    }

    @Test
    void testMultipleMessagesCanBeRead() {
        when(repository.findAll()).thenReturn(List.of(message));

        var msgs = repository.findAll();
        assertThat(msgs, hasSize(1) );
        assertThat(msgs, hasItem(message));
    }

}