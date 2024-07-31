package vn.t3h.class2109.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product", schema = "sanphamnoithat", catalog = "")
public class ProductEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "brand", nullable = true, length = 255)
    private String brand;
    @Basic
    @Column(name = "price", nullable = true)
    private Long price;
    @Basic
    @Column(name = "description", nullable = true, length = 500)
    private String description;
    @Basic
    @Column(name = "category", nullable = true)
    private Long category;
    @Basic
    @Column(name = "image", nullable = true, length = 255)
    private String image;

}
