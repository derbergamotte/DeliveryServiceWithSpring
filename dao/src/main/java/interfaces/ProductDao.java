package interfaces;

import java.util.Collection;

import entities.Attribute;
import entities.Category;
import entities.Product;

public interface ProductDao extends GenericDao<Product> {


	Collection<Product> findByAttributes(Collection<Attribute> attributes);

	Collection<Product> findByCategory(Category category);
}
