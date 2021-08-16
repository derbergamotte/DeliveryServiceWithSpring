package com.ak.implementation;

import com.ak.dto.ProductDto;
import com.ak.entities.Product;
import com.ak.repository.interfaces.AttributeDao;
import com.ak.repository.interfaces.CategoryDao;
import com.ak.repository.interfaces.ProductDao;
import com.ak.interfaces.ProductService;
import com.ak.mappers.ProductMapper;
import com.ak.util.filemanager.DtoJsonFileManager;
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
    @Autowired
    private DtoJsonFileManager dtoJsonFileManager;

    @Override
    public ProductDto add(ProductDto productDto){
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

}
