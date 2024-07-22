package vn.t3h.class2109.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.KhachHangdto;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.dto.TableDataDto;
import vn.t3h.class2109.entities.ProductEntity;
import vn.t3h.class2109.entities.UserEntity;
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.repositories.ProductRepository;
import vn.t3h.class2109.utils.DbUtil;

import javax.persistence.EntityNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements TableService{
    @Autowired
    ProductRepository productRepository;


    public ProductEntity saveProduct(ProductDto productDto) {
        return productRepository.save(productDto.mapperEntity());
    }

    public ProductEntity delete(Long id) {
        // Tìm sản phẩm theo id
        Optional<ProductEntity> productOptional = productRepository.findById(id);

        // Nếu sản phẩm tồn tại
        if (productOptional.isPresent()) {
            ProductEntity product = productOptional.get();
            productRepository.delete(product);
            return product; // Trả về sản phẩm đã bị xóa
        } else {
            // Nếu sản phẩm không tồn tại, có thể ném một ngoại lệ hoặc trả về null
            throw new EntityNotFoundException("Product not found with id: " + id);
            // Hoặc return null; nếu không muốn ném ngoại lệ
        }
    }

    public ProductEntity editProduct(ProductDto productDto) {
        if (productDto == null || productDto.getId() == null || productDto.getId() < 0) {
            throw new IllegalArgumentException("Invalid productDto or productDto ID");
        }

        // Tìm sản phẩm hiện tại trong cơ sở dữ liệu
        Optional<ProductEntity> optionalProduct = productRepository.findById(productDto.getId());

        if (!optionalProduct.isPresent()) {
            throw new EntityNotFoundException("Product not found with id: " + productDto.getId());
        }

        // Cập nhật thông tin sản phẩm
        ProductEntity product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());

        // Lưu lại sản phẩm đã cập nhật
        ProductEntity updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    public void findAll(PagingAndSortOject page) {
        page.findAll(productRepository);
    }



    // frontend
    public List<ProductDto> findAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(ProductDto::fromEntity)
                .collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }

        return ProductDto.fromEntity(optionalProduct.get());
    }

}
