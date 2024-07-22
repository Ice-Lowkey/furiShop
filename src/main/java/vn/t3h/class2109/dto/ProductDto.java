package vn.t3h.class2109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.t3h.class2109.entities.ProductEntity;
import vn.t3h.class2109.entities.UserEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    Long id;// định danh sản phẩm
    Long price;
    String name;
    String brand;
    String description;
    Long category;
    String image;

    public ProductEntity mapperEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(id);
        productEntity.setName(name);
        productEntity.setBrand(brand);
        productEntity.setPrice(price);
        productEntity.setDescription(description);
        productEntity.setCategory(category);
        productEntity.setImage(image);
        return productEntity;
    }

    public static ProductDto fromEntity(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }

        ProductDto dto = new ProductDto();
        dto.setId(productEntity.getId());
        dto.setName(productEntity.getName());
        dto.setBrand(productEntity.getBrand());
        dto.setPrice(productEntity.getPrice());
        dto.setCategory(productEntity.getCategory());
        dto.setDescription(productEntity.getDescription());
        dto.setImage(productEntity.getImage());

        return dto;
    }
}
