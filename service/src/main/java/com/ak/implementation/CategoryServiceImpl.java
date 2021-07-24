package com.ak.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ak.dto.CategoryDto;
import com.ak.entities.Category;
import com.ak.interfaces.CategoryService;
import com.ak.interfaces.CategoryDao;
import com.ak.mappers.CategoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public CategoryDto add(CategoryDto categoryDto) {
        return CategoryMapper.INSTANCE.toDto(categoryDao.add(CategoryMapper.INSTANCE.toEntity(categoryDto)));
    }

    public CategoryDto getById(Long id) {
        return CategoryMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Collection<CategoryDto> getAll() {
        return categoryDao.getAll().stream().map(CategoryMapper.INSTANCE::toDto).collect(Collectors.toSet());
    }

    public void remove(Long categoryId) {
        categoryDao.remove(categoryId);
    }

    public void update(CategoryDto categoryDto) {
        if (categoryDto.getId() != null) {
            return;
        }
        Category category = getEntityById(categoryDto.getId());
        if (StringUtils.isNotEmpty(categoryDto.getName())) {
            category.setName(categoryDto.getName());
        }
        categoryDao.update(category);
    }

    private Category getEntityById(Long id) {
        return categoryDao.get(id);
    }
}
