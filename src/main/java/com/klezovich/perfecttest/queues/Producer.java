package com.klezovich.perfecttest.queues;

import lombok.extern.java.Log;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@Log
public class Producer {

    private final Queue queue;
    private final JmsTemplate template;

    public Producer(Queue queue, JmsTemplate template) {
        this.queue = queue;
        this.template = template;
    }

    @Scheduled(fixedDelay = 1000)
    public void produceMessages() {
        String message = "msg:" + System.currentTimeMillis();
        log.info("PRODUCER: Sent" + message);
        template.convertAndSend(queue, message);
    }
}
