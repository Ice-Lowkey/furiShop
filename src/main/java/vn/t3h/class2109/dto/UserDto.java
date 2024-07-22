package vn.t3h.class2109.dto;


import lombok.Data;
import vn.t3h.class2109.entities.UserEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {
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
    String role;

    public UserEntity mapperEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setUsername(username);
        userEntity.setPhone(phone);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setRole(role);
        return userEntity;
    }

}
