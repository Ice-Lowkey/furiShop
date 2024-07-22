package vn.t3h.class2109.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "customer", schema = "sanphamnoithat", catalog = "")
public class CustomerEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    private String phone;

    @Basic
    @Column(name= "address", nullable = true, length = 255)
    private String address;

}
