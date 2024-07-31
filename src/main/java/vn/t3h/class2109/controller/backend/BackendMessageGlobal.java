package vn.t3h.class2109.controller.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import vn.t3h.class2109.entities.MessageEntity;
import vn.t3h.class2109.service.MessageService;

import java.util.List;

@ControllerAdvice

public class BackendMessageGlobal {

    @Autowired
    MessageService messageService;

    @ModelAttribute("messages")
    public List<MessageEntity> populateMessages() {
        return messageService.getAll();
    }
}
