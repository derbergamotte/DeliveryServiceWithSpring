package com.ak.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ak.entities.Attribute;
import com.ak.entities.Category;
import com.ak.entities.Product;
import com.ak.interfaces.ProductDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

    private ProductDaoImpl() {
        super(Product.class);
    }

    public Collection<Product> findByAttributes(Collection<Attribute> attributes){
        return getAll().stream().filter(p->p.getAttributes().containsAll(attributes)).collect(Collectors.toSet());
    }

    public Collection<Product> findByCategory(Category category){
        return getAll().stream().filter(p->p.getCategories().contains(category)).collect(Collectors.toSet());
    }
}
