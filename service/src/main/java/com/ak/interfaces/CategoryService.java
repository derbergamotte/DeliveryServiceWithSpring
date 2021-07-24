package com.ak.interfaces;

import com.ak.dto.CategoryDto;

import java.util.Collection;

public interface CategoryService {

    CategoryDto add(CategoryDto categoryDto);

    CategoryDto getById(Long id);

    Collection<CategoryDto> getAll();

    void remove(Long categoryId);

    void update(CategoryDto categoryDto);
}
