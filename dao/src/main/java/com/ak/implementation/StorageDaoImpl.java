package com.ak.implementation;

import com.ak.entities.Storage;
import com.ak.interfaces.StorageDao;
import org.springframework.stereotype.Repository;

@Repository
public class StorageDaoImpl extends GenericDaoImpl<Storage> implements StorageDao {

    StorageDaoImpl() {
        super(Storage.class);
    }
}
