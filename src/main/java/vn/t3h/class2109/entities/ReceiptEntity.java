package vn.t3h.class2109.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "receipt", schema = "sanphamnoithat", catalog = "")

public class ReceiptEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "productid", nullable = false)
    private Long productid;

    @Basic
    @Column(name = "userid", nullable = false)
    private Long userid;

    @Basic
    @Column(name = "productimg" , nullable = true)
    private String productimg;

    @Basic
    @Column(name = "number" , nullable = true)
    private int number;

    @Basic
    @Column(name = "productprice" , nullable = false)
    private Long productprice;

    @Basic
    @Column(name = "productname" , nullable = false)
    private String productname;
}

