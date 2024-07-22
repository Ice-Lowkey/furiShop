package vn.t3h.class2109.dto;


import lombok.Data;
import vn.t3h.class2109.entities.CartEntity;

@Data
public class CartDto {
    Long id;
    Long customerid;
    String firstname;
    String lastname;
    String companyname;
    String address;
    String state;
    String posta;
    String email;
    String phone;
    String total;


    public CartEntity mapperEntity() {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(id);
        cartEntity.setCustomerid(customerid);
        cartEntity.setFirstname(firstname);
        cartEntity.setLastname(lastname);
        cartEntity.setCompanyname(companyname);
        cartEntity.setAddress(address);
        cartEntity.setState(state);
        cartEntity.setPosta(posta);
        cartEntity.setEmail(email);
        cartEntity.setPhone(phone);
        cartEntity.setTotal(total);
        return cartEntity;
    }

}
