package com.ak.repository.interfaces;

import com.ak.entities.Product;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductDao extends GenericDao<Product> {

}
