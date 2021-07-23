package implementation;

import java.util.Collection;

import dto.StoreDto;
import entities.Store;
import interfaces.StoreDao;
import interfaces.StoreService;
import mappers.StoreMapper;
import org.apache.commons.lang3.StringUtils;

public class StoreServiceImpl implements StoreService {

    private final StoreDao storeDao = StoreDaoImpl.getStoreDao();

    private static StoreServiceImpl storeService;

    private StoreServiceImpl() {
    }

    public static StoreServiceImpl getStoreService() {
        if (storeService == null) {
            storeService = new StoreServiceImpl();
        }
        return storeService;
    }

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
