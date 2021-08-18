package com.ak.interfaces;

import com.ak.dto.ProductDto;

import java.util.Collection;

public interface ProductService extends EntityService<ProductDto>{

    Collection<ProductDto> getByAttributes(Collection<Long> attributesId);
    Collection<ProductDto> getByCategories(Collection<Long> categoriesId);
}
