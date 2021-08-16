package com.ak.repository.interfaces;

import com.ak.entities.Storage;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface StorageDao extends GenericDao<Storage> {

}
