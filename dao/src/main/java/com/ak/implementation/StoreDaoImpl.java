package com.ak.implementation;

import com.ak.entities.Store;
import com.ak.interfaces.StoreDao;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl extends GenericDaoImpl<Store> implements StoreDao {

    StoreDaoImpl() {
        super(Store.class);
    }
}
