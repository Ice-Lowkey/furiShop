package vn.t3h.class2109.controller.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.CustomerDto;
import vn.t3h.class2109.entities.CustomerEntity;
import vn.t3h.class2109.service.CustomerService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BackendCustomerController {
    @Autowired
    CustomerService customerService;


    @RequestMapping(value = {"/", "signup"})
    public String SignIN() {
        return "backend/signup";
    }



    @RequestMapping(value = "customer/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String taoMoiUser(RedirectAttributes model,
                             @Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        if(bindingResult.hasErrors())
            return "backend/signup";
        List<CustomerDto> customerDtos = customerService.findAll();
        for (CustomerDto customer : customerDtos) {
            if (customerDto.getUsername().equals(customer.getUsername())){
                model.addFlashAttribute("message" , "Tài khoản đã tồn tại");
                return "redirect:/signup";
            }
        }
        CustomerEntity result = customerService.save(customerDto);
        model.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/home"; // đọc text từ file jsp và render ra html
    }
}
