package vn.t3h.class2109.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.t3h.class2109.dto.MessageDto;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.dto.ReceiptDto;
import vn.t3h.class2109.entities.MessageEntity;
import vn.t3h.class2109.service.MessageService;
import vn.t3h.class2109.service.ProductService;
import vn.t3h.class2109.service.ReceiptService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontEndHomeController {

    @Autowired
    ProductService productService;

    @Autowired
    ReceiptService receiptService;

    @Autowired
    MessageService messageService;

    @RequestMapping(value = {"/", "home"})
    public String homePage(Model model){
        //1: Lấy từ db danh sách sản phẩm
        List<ProductDto> productDtos = new ArrayList<>();
        model.addAttribute("products", productDtos);
        return "frontend/home";
    }

    @RequestMapping(value = {"/", "blog"})
    public String blogPage(Model model){
        model.addAttribute("blog" ,"day la trang blog");
        return "frontend/blog";
    }

//    @RequestMapping(value = {"/", "cart/{id}"})
//    public String cartPage(Model model ,@PathVariable Long id) {
//        ProductDto productDto = productService.findById(id);
//        model.addAttribute("product", productDto);
//        return "frontend/cart";
//    }
    @RequestMapping(value = {"/", "cart"})
    public String cartPageNone(Model model ) {
        model.addAttribute("message","đơn hàng rỗng" );
        List<ReceiptDto> cartItems = receiptService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "frontend/cart";
    }

    @RequestMapping(value = {"/", "checkout"})
    public String checkOutPage(Model model){
        model.addAttribute("checkout" ,"day la trang checkout");
        List<ReceiptDto> cartItems = receiptService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "frontend/checkout";
    }

    @RequestMapping(value = {"/", "contact"})
    public String contactPage(Model model){
        model.addAttribute("messages" , "contact");
        return "frontend/contact";
    }

    @RequestMapping(value = {"/", "about"})
    public String aboutPage(Model model){
        model.addAttribute("about" ,"day la trang about");
        return "frontend/intro";
    }

    @RequestMapping(value = {"/", "services"})
    public String servicePage(Model model){
        model.addAttribute("k" ,"day la trang service");
        return "frontend/services";
    }

    @RequestMapping(value = {"/", "shop"})
    public String shopPage(Model model) {
        List<ProductDto> products = productService.findAll();
        model.addAttribute("products", products);

        return "frontend/shop";
    }

    @RequestMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable Long id) {
        ProductDto productDto = productService.findById(id);
        model.addAttribute("product", productDto);

        return "frontend/detail";
    }

    @RequestMapping(value = {"/", "thankyou"})
    public String thankYouPage(Model model){
        model.addAttribute("thank" ,"day la trang thankyou");
        receiptService.clearCart();
        return "frontend/thankyou";
    }
}
