package com.klezovich.perfecttest.msgservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klezovich.perfecttest.msgservice.domain.entity.Message;
import com.klezovich.perfecttest.msgservice.domain.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class MessageControllerTest {

    private MockMvc mvc;

    @Mock
    private MessageService service;

    @Mock
    private MessageDtoMapper mapper;

    @InjectMocks
    private MessageController controller;

    private JacksonTester<MessageDto> jsonMessageDto;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        JacksonTester.initFields(this, new ObjectMapper());

        WebApplicationContext context;
        mvc = MockMvcBuilders.standaloneSetup(controller)
            .setControllerAdvice(new GlobalControllerAdvice())
            .build();
    }

    @Test
    public void canSaveMessage() throws Exception {
        var messageDto = new MessageDto(0L, "hello");
        var message = new Message(messageDto.getId(), messageDto.getMessage());

        when(mapper.toMessage(messageDto)).thenReturn(message);
        when(service.save(message)).thenReturn(true);

        var response = mvc.perform(
            post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMessageDto.write(messageDto).getJson())
        )
            .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
        verify(service).save(message);
    }

    @Test
    public void canGetMessage() throws Exception {
        var id = 0L;
        var text = "hello";

        var message = new Message(id,text);
        var messageDto = new MessageDto(id,text);

        when(service.get(message.getId())).thenReturn(Optional.of(message));
        when(mapper.toMessageDto(message)).thenReturn(messageDto);

        var response = mvc.perform(
            get("/get/"+id)
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), is(jsonMessageDto.write(messageDto).getJson()));
    }

    @Test
    public void notFoundMessageMapsToNotFoundResponseCode() throws Exception {
        var id = 0L;
        var text = "hello";

        var message = new Message(id,text);
        var messageDto = new MessageDto(id,text);

        when(service.get(id)).thenThrow(NoSuchElementException.class);

        var response = mvc.perform(
            get("/get/"+id)
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.NOT_FOUND.value()));
    }
}