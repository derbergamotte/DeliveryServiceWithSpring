package com.ak.mappers;

import com.ak.dto.ProductDto;
import com.ak.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface ProductMapper extends EntityMapper<Product, ProductDto> {

}
