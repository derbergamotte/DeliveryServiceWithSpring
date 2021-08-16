package com.ak.implementation;

import com.ak.dto.StorageDto;
import com.ak.entities.Storage;
import com.ak.interfaces.ProductService;
import com.ak.interfaces.StorageService;
import com.ak.repository.interfaces.StorageDao;
import com.ak.mappers.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl extends EntityServiceImpl<Storage, StorageDto> implements StorageService {

    @Autowired
    private StorageDao storageDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private StorageMapper storageMapper;

    public StorageDto update(Long id, StorageDto storageDto) {
        Storage storage = getEntityById(id);
        if (storageDto.getId() == null) {
            return storageDto;
        }
        if (!(storageDto.getQuantity() == null)) {
            storage.setQuantity(storageDto.getQuantity());
        }
        if (!(storageDto.getPrice() == null)) {
            storage.setPrice(storageDto.getPrice());
        }
        return storageMapper.toDto(storageDao.saveAndFlush(storage));
    }
}
