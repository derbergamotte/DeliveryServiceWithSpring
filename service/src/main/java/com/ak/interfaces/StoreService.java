package com.ak.interfaces;

import com.ak.dto.StoreDto;

import java.util.Collection;

public interface StoreService {

    StoreDto add(StoreDto storeDto);

    StoreDto getById(Long id);

    Collection<StoreDto> getAll();

    void remove(Long orderId);

    void update(StoreDto storeDto);
}
