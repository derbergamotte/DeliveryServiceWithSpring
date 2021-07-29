package com.ak.interfaces;

import com.ak.dto.ProductDto;

import java.util.Collection;

public interface ProductService extends EntityService<ProductDto>{

    Collection<ProductDto> getByCategoryById(Long categoryId);

    Collection<ProductDto> findByAttributes(Collection<Long> listAttributes);
}
