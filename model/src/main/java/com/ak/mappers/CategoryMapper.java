package com.ak.mappers;

import com.ak.dto.CategoryDto;
import com.ak.entities.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper extends EntityMapper<Category, CategoryDto>{

}
