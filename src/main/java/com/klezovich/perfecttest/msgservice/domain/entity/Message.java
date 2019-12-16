package com.klezovich.perfecttest.msgservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private Long id;
    private String message;
}
