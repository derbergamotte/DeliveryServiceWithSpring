package com.ak.interfaces;

import com.ak.dto.StorageDto;

import java.util.Collection;

public interface StorageService extends EntityService<StorageDto>{

    Collection<StorageDto> sortProductByPriceInStores(Long productId);
}
