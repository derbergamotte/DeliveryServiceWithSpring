package com.ak.implementation;

import com.ak.dto.BaseDto;
import com.ak.dto.ProductDto;
import com.ak.entities.Product;
import com.ak.repository.interfaces.ProductDao;
import com.ak.interfaces.ProductService;
import com.ak.mappers.ProductMapper;
import com.ak.util.filemanager.DtoJsonFileManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends EntityServiceImpl<Product, ProductDto> implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private DtoJsonFileManager dtoJsonFileManager;

    @Override
    public ProductDto add(ProductDto productDto) {
        productDto = super.add(productDto);
        dtoJsonFileManager.save(productDto);
        return productDto;
    }

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

    public Collection<ProductDto> getByAttributes(Collection<Long> attributesId) {
        return super.getAll().stream()
                .filter(p -> p.getAttributes().stream()
                        .map(BaseDto::getId).collect(Collectors.toSet())
                .containsAll(attributesId)).collect(Collectors.toSet());
    }

    public Collection<ProductDto> getByCategories(Collection<Long> categoriesId) {
        return super.getAll().stream()
                .filter(p -> p.getCategories().stream()
                        .map(BaseDto::getId).collect(Collectors.toSet())
                .containsAll(categoriesId)).collect(Collectors.toSet());
    }
}
