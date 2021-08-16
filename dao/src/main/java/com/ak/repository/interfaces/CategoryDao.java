package com.ak.repository.interfaces;

import com.ak.entities.Category;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CategoryDao extends GenericDao<Category> {

}
