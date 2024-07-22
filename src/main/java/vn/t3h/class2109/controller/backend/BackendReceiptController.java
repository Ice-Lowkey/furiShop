package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.t3h.class2109.dto.ReceiptDto;
import vn.t3h.class2109.service.ReceiptService;
import vn.t3h.class2109.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class BackendReceiptController {

    @Autowired
    ReceiptService receiptService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.POST)
    @ResponseBody
    public String addToCart(@PathVariable Long productId , Model model) {
        if (userService.getCurrentUserId() == null) {
            model.addAttribute("note", "bạn phải đăng nhập trước");
        }
        else {
            receiptService.addProductToReceipt(productId);
        }

        return "success";
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String getCartContent(Model model) {
        List<ReceiptDto> cartItems = receiptService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "frontend/receipt/content";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clearCart() {
        receiptService.clearCart();
        return "redirect:/cart/content";
    }
}

