package com.klezovich.perfecttest.msgservice.controller;

import lombok.Value;

@Value
public class MessageDto {

    private final Long id;
    private final String message;
}
