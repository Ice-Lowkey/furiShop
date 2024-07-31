package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.MessageDto;
import vn.t3h.class2109.service.MessageService;

import javax.validation.Valid;


@Controller

public class BackendMessageController {
    @Autowired
    MessageService messageService;


    @PostMapping(value = "/contact/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveMessages(RedirectAttributes redirectAttributes, @Valid @ModelAttribute MessageDto messageDto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("messages", "contact");
            return "frontend/contact";
        }
        messageService.saveMessage(messageDto);
        redirectAttributes.addFlashAttribute("message", "gửi thành công");
        return "redirect:/contact";
    }

}
