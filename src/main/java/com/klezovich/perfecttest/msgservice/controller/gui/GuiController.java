package com.klezovich.perfecttest.msgservice.controller.gui;

import com.klezovich.perfecttest.msgservice.controller.MessageDto;
import com.klezovich.perfecttest.msgservice.controller.MessageDtoMapper;
import com.klezovich.perfecttest.msgservice.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gui")
public class GuiController {

    private final MessageService service;
    private final MessageDtoMapper mapper;

    @Autowired
    public GuiController(
        MessageService service,
        MessageDtoMapper mapper
    ) {
        this.service = service;
        this.mapper = mapper;
    }

    @RequestMapping("/index")
    public String showGuiPage(Model m) {
        m.addAttribute("messageDto", new MessageDto());
        m.addAttribute("messages", service.getAll());
        return "index";
    }

    @RequestMapping("/save")
    public String showGuiPage(@ModelAttribute("messageDto") MessageDto dto) {
         service.save(mapper.toMessage(dto));
         return "redirect:/gui/index";
    }
}
