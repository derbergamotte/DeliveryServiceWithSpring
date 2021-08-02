package com.ak.implementation;

import com.ak.entities.Category;
import com.ak.interfaces.CategoryDao;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {

	CategoryDaoImpl() {
		super(Category.class);
	}
}
