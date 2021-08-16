package com.ak.implementation;

import com.ak.dto.CategoryDto;
import com.ak.entities.Category;
import com.ak.interfaces.CategoryService;
import com.ak.repository.interfaces.CategoryDao;
import com.ak.mappers.CategoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends EntityServiceImpl<Category, CategoryDto> implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDto update(Long id, CategoryDto categoryDto) {
        if (categoryDto.getId() == null) {
            return categoryDto;
        }
        Category category = getEntityById(id);
        if (StringUtils.isNotEmpty(categoryDto.getName())) {
            category.setName(categoryDto.getName());
        }
        return categoryMapper.toDto(categoryDao.saveAndFlush(category));
    }
}
