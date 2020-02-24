package com.klezovich.perfecttest.tech.queues;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class JmsConfig {

    @Bean
    public Queue createTestQueue() {
        return new ActiveMQQueue("test-queue");
    }
}
