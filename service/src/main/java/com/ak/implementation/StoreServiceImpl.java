package com.ak.implementation;

import com.ak.dto.StoreDto;
import com.ak.entities.Store;
import com.ak.interfaces.StoreService;
import com.ak.repository.interfaces.StoreDao;
import com.ak.mappers.StoreMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl extends EntityServiceImpl<Store, StoreDto> implements StoreService {

    @Autowired
    private StoreDao storeDao;
    @Autowired
    private StoreMapper storeMapper;

    public StoreDto update(Long id, StoreDto storeDto) {
        if (storeDto.getId() == null) {
            return storeDto;
        }
        Store store = getEntityById(id);
        if (StringUtils.isNotEmpty(storeDto.getName())) {
            store.setName(storeDto.getName());
        }
        if (StringUtils.isNotEmpty(storeDto.getAddress())) {
            store.setAddress(storeDto.getAddress());
        }
        if (StringUtils.isNotEmpty(storeDto.getPhone())) {
            store.setPhone(storeDto.getPhone());
        }
       return storeMapper.toDto(storeDao.saveAndFlush(store));
    }
}
