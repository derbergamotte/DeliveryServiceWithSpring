package com.ak.mappers;

import com.ak.dto.ProductDto;
import com.ak.entities.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper extends EntityMapper<Product, ProductDto> {

}
