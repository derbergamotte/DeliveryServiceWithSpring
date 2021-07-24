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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private AttributeDao attributeDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private AttributeService attributeService;

    public ProductDto add(ProductDto productDto) {
        productDto.setAttributes(productDto.getAttributes().stream().map(attributeService::getElseAdd).collect(Collectors.toSet()));
        return ProductMapper.INSTANCE.toDto(productDao.add(ProductMapper.INSTANCE.toEntity(productDto)));
    }

    public ProductDto getById(Long id) {
        return ProductMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Collection<ProductDto> getAll() {
        return ProductMapper.INSTANCE.toDto(productDao.getAll());
    }

    public void remove(Long orderId) {
        productDao.remove(orderId);
    }

    public void update(ProductDto productDto) {
        if (productDto.getId() != null) {
            return;
        }
        Product product = getEntityById(productDto.getId());
        if (StringUtils.isNotEmpty(productDto.getName())) {
            product.setName(productDto.getName());
        }
        if (StringUtils.isNotEmpty(productDto.getInformation())) {
            product.setInformation(productDto.getInformation());
        }
        productDao.update(product);
    }

    public Collection<ProductDto> getByCategoryById(Long categoryId) {
        return ProductMapper.INSTANCE.toDto(productDao.findByCategory(categoryDao.get(categoryId)));
    }

    public Collection<ProductDto> findByAttributes(Collection<Long> listAttributesId) {
        return ProductMapper.INSTANCE.toDto(productDao.findByAttributes(
                listAttributesId.stream()
                        .map(attributeDao::get)
                        .collect(Collectors.toSet())));
    }

    private Product getEntityById(Long id) {
        return productDao.get(id);
    }
}
