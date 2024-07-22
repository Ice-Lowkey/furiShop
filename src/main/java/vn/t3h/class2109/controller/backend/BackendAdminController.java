package vn.t3h.class2109.controller.backend;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAnyRole('ADMIN' , 'USER' )")
public class BackendAdminController {

    @RequestMapping(value = "/backend/home")
    public String homeBackend() {
        return "/backend/home";
    }


    @RequestMapping(value = "backend/chart")
    public String chartBackend() {
        return "backend/chart/chart";
    }
}
