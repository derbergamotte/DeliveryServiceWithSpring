package implementation;

import entities.Storage;
import interfaces.StorageDao;

public class StorageDaoImpl extends GenericDaoImpl<Storage> implements StorageDao {

    private StorageDaoImpl() {
        super(Storage.class);
    }

    private static StorageDaoImpl storageDao;

    public static StorageDaoImpl getStorageDao() {
        if (storageDao == null) {
            storageDao = new StorageDaoImpl();
        }
        return storageDao;
    }
}
