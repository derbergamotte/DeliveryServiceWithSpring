package com.ak.interfaces;

import java.util.Collection;

import com.ak.entities.Attribute;
import com.ak.entities.Category;
import com.ak.entities.Product;

public interface ProductDao extends GenericDao<Product> {


	Collection<Product> findByAttributes(Collection<Attribute> attributes);

	Collection<Product> findByCategory(Category category);
}
