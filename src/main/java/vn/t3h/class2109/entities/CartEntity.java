package vn.t3h.class2109.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "cart", schema = "sanphamnoithat", catalog = "")
public class CartEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "customerid", nullable = false)
    private Long customerid;

    @Basic
    @Column(name = "firstname", nullable = true , length = 255)
    private String firstname;

    @Basic
    @Column(name = "lastname", nullable = true , length = 255)
    private String lastname;

    @Basic
    @Column(name = "companyname", nullable = true , length = 500)
    private String companyname;

    @Basic
    @Column(name = "address", nullable = false , length = 500)
    private String address;

    @Basic
    @Column(name = "state", nullable = false ,length = 500)
    private String state;

    @Basic
    @Column(name = "posta", nullable = false , length = 25)
    private String posta;

    @Basic
    @Column(name = "email", nullable = false , length = 45)
    private String email;

    @Basic
    @Column(name = "phone", nullable = false , length = 11)
    private String phone;

    @Basic
    @Column(name = "total", nullable = false)
    private String total;
}
