package com.ak.interfaces;

import com.ak.dto.ProductDto;

import java.util.Collection;

public interface ProductService {

    ProductDto add(ProductDto productDto);

    ProductDto getById(Long id);

    Collection<ProductDto> getAll();

    void remove(Long orderId);

    void update(ProductDto productDto);

    Collection<ProductDto> getByCategoryById(Long categoryId);

    Collection<ProductDto> findByAttributes(Collection<Long> listAttributes);
}
