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
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;
    @Autowired
    private ProductService productService;

    public StorageDto add(StorageDto storageDto) {
        return StorageMapper.INSTANCE.toDto(storageDao.add(StorageMapper.INSTANCE.toEntity(storageDto)));
    }

    public StorageDto getById(Long id) {
        return StorageMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Collection<StorageDto> getAll() {
        return StorageMapper.INSTANCE.toDto(storageDao.getAll());
    }

    public void remove(Long id) {
        storageDao.remove(id);
    }

    public void update(StorageDto storageDto) {
        Storage storage = getEntityById(storageDto.getId());
        if (storageDto.getId() == null) {
            return;
        }
        if (!(storageDto.getQuantity() == null)) {
            storage.setQuantity(storageDto.getQuantity());
        }
        if (!(storageDto.getPrice() == null)) {
            storage.setPrice(storageDto.getPrice());
        }
        storageDao.update(storage);
    }

    public Collection<StorageDto> sortProductByPriceInStores(Long productId) {
        return productService.getById(productId).getStorages()
                .stream()
                .sorted(Comparator.comparing(StorageDto::getPrice))
                .collect(Collectors.toList());
    }

    private Storage getEntityById(Long id) {
        return storageDao.get(id);
    }
}
