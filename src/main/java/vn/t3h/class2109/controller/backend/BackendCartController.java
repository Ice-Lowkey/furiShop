package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.CartDto;
import vn.t3h.class2109.entities.CartEntity;
import vn.t3h.class2109.service.CartService;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller

public class BackendCartController {

    @Autowired
    CartService cartService;

    @RequestMapping(value = "checkout/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String taoMoiUser(RedirectAttributes model,
                             @Valid @ModelAttribute CartDto cartDto , BindingResult bindingResult) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        if(bindingResult.hasErrors())
            return "checkout";
        CartEntity result = cartService.save(cartDto);
        model.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/thankyou"; // đọc text từ file jsp và render ra html
    }


}