package vn.t3h.class2109.controller.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.t3h.class2109.service.MessageService;

@Controller
@PreAuthorize("hasAnyRole('ADMIN' , 'USER' )")
public class BackendAdminController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/backend/home")
    public String homeBackend() {
//        model.addAttribute("messages" , messageService.getAll());
        return "/backend/home";
    }


    @RequestMapping(value = "backend/chart")
    public String chartBackend() {
        return "backend/chart/chart";
    }
}
