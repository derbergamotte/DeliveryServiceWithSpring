package interfaces;

import dto.StorageDto;
import entities.Storage;

import java.util.Collection;

public interface StorageService {

    StorageDto add(StorageDto storageDto);

    StorageDto getById(Long id);

    Collection<StorageDto> getAll();

    void remove(Long id);

    void update(StorageDto storageDto);

    Collection<StorageDto> sortProductByPriceInStores(Long productId);
}
