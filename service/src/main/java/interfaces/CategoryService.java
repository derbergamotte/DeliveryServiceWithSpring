package interfaces;

import dto.CategoryDto;
import entities.Category;

import java.util.Collection;

public interface CategoryService {

    CategoryDto add(CategoryDto categoryDto);

    CategoryDto getById(Long id);

    Collection<CategoryDto> getAll();

    void remove(Long categoryId);

    void update(CategoryDto categoryDto);
}
