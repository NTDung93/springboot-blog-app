package ntd.springboot.blogapprestapi.service;

import ntd.springboot.blogapprestapi.model.entity.Category;
import ntd.springboot.blogapprestapi.model.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto getCategory(Long id);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(CategoryDto categoryDto, long categoryId);
    void deleteCategory(long id);
}
