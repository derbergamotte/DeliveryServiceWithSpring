package implementation;

import entities.Store;
import interfaces.StoreDao;

public class StoreDaoImpl extends GenericDaoImpl<Store> implements StoreDao {

    private StoreDaoImpl() {
        super(Store.class);
    }

    private static StoreDaoImpl storeDao;

    public static StoreDao getStoreDao() {
        if (storeDao == null) {
            storeDao = new StoreDaoImpl();
        }
        return storeDao;
    }
}
