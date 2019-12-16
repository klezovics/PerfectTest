package com.klezovich.perfecttest.msgservice.domain.entity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MessageTest {

    @Test
    public void testConstructor() {
        long id = 1L;
        var msg = "This is a message";

        var message = new Message(id, msg);
        assertThat(id, is(message.getId()));
        assertThat(msg, is(message.getMessage()));
    }
}