package vn.t3h.class2109.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.CustomerDto;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.dto.ReceiptDto;
import vn.t3h.class2109.entities.CustomerEntity;
import vn.t3h.class2109.entities.ReceiptEntity;
import vn.t3h.class2109.repositories.ReceiptRepository;

import javax.servlet.http.HttpSession;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceiptService {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private HttpSession session;

    public void addProductToReceipt(Long productId) {

        List<ReceiptDto> cartItems = (List<ReceiptDto>) session.getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }
        boolean appear = false;

        for (ReceiptDto cartItem : cartItems) {
            if(cartItem.getProductid() == productId){
                cartItem.setNumber(cartItem.getNumber()+1);
                appear = true;
                break;
            }
        }

        if (!appear) {
            ProductDto productDto = productService.findById(productId);
            ReceiptDto receiptDto = new ReceiptDto();

            // Lấy userId từ UserService
//            Long userId = userService.getCurrentUserId();
            String username = userService.getCurrentUserName();
            long userId = 0;
            List<CustomerDto> customerDtos = customerService.findAll();
            for(CustomerDto customerDto : customerDtos) {
                if (username.equals(customerDto.getUsername())){
                    userId = customerDto.getId();
                }
            }

            receiptDto.setProductid(productDto.getId());
            receiptDto.setUserid(userId);
            receiptDto.setProductimg(productDto.getImage());
            receiptDto.setNumber(1);
            receiptDto.setProductprice(productDto.getPrice());
            receiptDto.setProductname(productDto.getName());
            cartItems.add(receiptDto);
        }

        session.setAttribute("cartItems", cartItems);
    }

    public List<ReceiptDto> getCartItems() {
        List<ReceiptDto> cartItems = (List<ReceiptDto>) session.getAttribute("cartItems");
        return cartItems != null ? cartItems : new ArrayList<>();
    }

    public void clearCart() {
        session.removeAttribute("cartItems");
    }
}

