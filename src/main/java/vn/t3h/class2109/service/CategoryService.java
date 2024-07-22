package vn.t3h.class2109.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.CategoryDto;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.dto.TableDataDto;
import vn.t3h.class2109.entities.CategoryEntity;
import vn.t3h.class2109.entities.UserEntity;
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.repositories.CategoryRepository;
import vn.t3h.class2109.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements TableService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void findAll(PagingAndSortOject page) {
        page.findAll(categoryRepository);
    }

    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

}
