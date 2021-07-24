package com.ak.implementation;

import java.util.Collection;

import com.ak.dto.StoreDto;
import com.ak.entities.Store;
import com.ak.interfaces.StoreService;
import com.ak.interfaces.StoreDao;
import com.ak.mappers.StoreMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    public StoreDto add(StoreDto storeDto) {
        return StoreMapper.INSTANCE.toDto(storeDao.add(StoreMapper.INSTANCE.toEntity(storeDto)));
    }

    public StoreDto getById(Long id) {
        return StoreMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Collection<StoreDto> getAll() {
        return StoreMapper.INSTANCE.toDto(storeDao.getAll());
    }

    public void remove(Long orderId) {
        storeDao.remove(orderId);
    }

    public void update(StoreDto storeDto) {

        if (storeDto.getId() != null) {
            return;
        }
        Store store = getEntityById(storeDto.getId());
        if (StringUtils.isNotEmpty(storeDto.getName())) {
            store.setName(storeDto.getName());
        }
        if (StringUtils.isNotEmpty(storeDto.getAddress())) {
            store.setAddress(storeDto.getAddress());
        }
        if (StringUtils.isNotEmpty(storeDto.getPhone())) {
            store.setPhone(storeDto.getPhone());
        }
        storeDao.update(store);
    }

    private Store getEntityById(Long id) {
        return storeDao.get(id);
    }
}
