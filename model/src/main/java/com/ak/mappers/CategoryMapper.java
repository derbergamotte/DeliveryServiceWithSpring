package com.ak.mappers;

import com.ak.dto.CategoryDto;
import com.ak.entities.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "id", target = "id")
    @InheritInverseConfiguration
    CategoryDto toDto(Category entity);

    Collection<CategoryDto> toDto(Collection<Category> categories);

    Category toEntity(CategoryDto dto);
}
