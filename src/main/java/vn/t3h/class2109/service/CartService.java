package vn.t3h.class2109.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.CartDto;

import vn.t3h.class2109.dto.CustomerDto;
import vn.t3h.class2109.entities.CartEntity;
import vn.t3h.class2109.repositories.CartRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    public CartEntity save(CartDto cartDto) {
        String username = userService.getCurrentUserName();
        long customerid = 0;
        List<CustomerDto> customerDtos = customerService.findAll();
        for(CustomerDto customerDto : customerDtos) {
            if (username.equals(customerDto.getUsername())){
                customerid = customerDto.getId();
            }
        }
        cartDto.setCustomerid(customerid);
        return cartRepository.save(cartDto.mapperEntity());
    }
}
