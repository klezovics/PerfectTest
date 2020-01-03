package com.klezovich.perfecttest.queues;

import lombok.extern.java.Log;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
@Log
public class Consumer {

    @JmsListener(destination = "test-queue")
    public void readMessages(String message) {
        log.info("RECEIVER: Received msg" + message);
    }
}
