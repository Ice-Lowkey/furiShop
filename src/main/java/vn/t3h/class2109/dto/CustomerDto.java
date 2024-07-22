package vn.t3h.class2109.dto;

import lombok.Data;
import vn.t3h.class2109.entities.CustomerEntity;
import vn.t3h.class2109.entities.ProductEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CustomerDto {
    Long id;
    @NotBlank(message = "Không được phép rỗng")
    @Size(message = "nhập ít nhất 6 ký tự", min = 4)
    String username;
    @NotBlank(message = "Không được phép rỗng")
    @Size(message = "nhập ít nhất 6 ký tự", min = 6)
    String password;
    String phone;
    String email;
    @NotBlank(message = "Không được phép rỗng")
    @Size(message = "nhập ít nhất 6 ký tự", min = 6)
    String repassword;
    String address;

    public CustomerEntity mapperEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(id);
        customerEntity.setUsername(username);
        customerEntity.setPassword(password);
        customerEntity.setPhone(phone);
        customerEntity.setEmail(email);
        customerEntity.setAddress(address);
        return customerEntity;
    }

    public static CustomerDto fromEntity(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }

        CustomerDto dto = new CustomerDto();
        dto.setId(customerEntity.getId());
        dto.setUsername(customerEntity.getUsername());
        dto.setPassword(customerEntity.getPassword());
        dto.setPhone(customerEntity.getPhone());
        dto.setEmail(customerEntity.getEmail());
        dto.setAddress(customerEntity.getAddress());
        return dto;
    }
}
