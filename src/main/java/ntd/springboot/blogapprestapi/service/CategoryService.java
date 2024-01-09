package ntd.springboot.blogapprestapi.service;

import ntd.springboot.blogapprestapi.model.entity.Category;
import ntd.springboot.blogapprestapi.model.payload.CategoryDto;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
}
