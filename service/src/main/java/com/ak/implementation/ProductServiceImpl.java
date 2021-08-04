package com.ak.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ak.dto.ProductDto;
import com.ak.entities.Product;
import com.ak.interfaces.*;
import com.ak.mappers.ProductMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends EntityServiceImpl<Product, ProductDto> implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private AttributeDao attributeDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductMapper productMapper;

    public ProductDto update(Long id, ProductDto productDto) {
        if (productDto.getId() == null) {
            return productDto;
        }
        Product product = getEntityById(id);
        if (StringUtils.isNotEmpty(productDto.getName())) {
            product.setName(productDto.getName());
        }
        if (StringUtils.isNotEmpty(productDto.getInformation())) {
            product.setInformation(productDto.getInformation());
        }
        return productMapper.toDto(productDao.saveAndFlush(product));
    }
}
