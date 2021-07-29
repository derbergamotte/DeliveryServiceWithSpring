package com.ak.implementation;

import com.ak.dto.StorageDto;
import com.ak.entities.Storage;
import com.ak.interfaces.ProductService;
import com.ak.interfaces.StorageService;
import com.ak.interfaces.StorageDao;
import com.ak.mappers.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl extends EntityServiceImpl<Storage, StorageDto> implements StorageService {

    @Autowired
    private StorageDao storageDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private StorageMapper storageMapper;

    public StorageDto update(StorageDto storageDto) {
        Storage storage = getEntityById(storageDto.getId());
        if (storageDto.getId() == null) {
            return storageDto;
        }
        if (!(storageDto.getQuantity() == null)) {
            storage.setQuantity(storageDto.getQuantity());
        }
        if (!(storageDto.getPrice() == null)) {
            storage.setPrice(storageDto.getPrice());
        }
        return storageMapper.toDto(storageDao.update(storage));
    }

    public Collection<StorageDto> sortProductByPriceInStores(Long productId) {
        return productService.getById(productId).getStorages()
                .stream()
                .sorted(Comparator.comparing(StorageDto::getPrice))
                .collect(Collectors.toList());
    }
}
