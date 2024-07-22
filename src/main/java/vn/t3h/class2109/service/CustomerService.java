package vn.t3h.class2109.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.CustomerDto;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.entities.CustomerEntity;
import vn.t3h.class2109.entities.ProductEntity;
import vn.t3h.class2109.entities.UserEntity; // Import UserEntity nếu chưa có
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.repositories.CustomerRepository;
import vn.t3h.class2109.repositories.UserRepository; // Import UserRepository nếu chưa có

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository; // Thêm UserRepository

    @Autowired
    PasswordEncoder passwordEncoder;

    public CustomerEntity save(CustomerDto customerDto) {
        // Tạo CustomerEntity từ CustomerDto và mã hóa mật khẩu
        CustomerEntity customerEntity = customerDto.mapperEntity();
        customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));

        // Lưu CustomerEntity vào database
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);

        // Tạo UserEntity từ thông tin của CustomerEntity
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(savedCustomer.getUsername());
        userEntity.setPassword(savedCustomer.getPassword());
        userEntity.setPhone(savedCustomer.getPhone());
        userEntity.setEmail(savedCustomer.getEmail());
        userEntity.setRole("CUSTOMER"); // Đặt role mặc định là "CUSTOMER"

        // Lưu UserEntity vào database
        userRepository.save(userEntity);

        return savedCustomer;
    }


    public List<CustomerDto> findAll() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
    }



}
