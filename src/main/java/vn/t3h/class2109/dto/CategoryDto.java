package vn.t3h.class2109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.t3h.class2109.entities.CategoryEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    Long id;
    String name;
    String description;

    public CategoryEntity mapperEntity() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(id);
        categoryEntity.setName(name);
        categoryEntity.setDescription(description);
        return categoryEntity;
    }

}

