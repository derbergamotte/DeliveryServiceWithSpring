package com.ak.repository.interfaces;

import com.ak.entities.Store;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface StoreDao extends GenericDao<Store> {

}
