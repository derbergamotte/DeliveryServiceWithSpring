package implementation;

import entities.Category;
import interfaces.CategoryDao;

public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {

	private CategoryDaoImpl() {
		super(Category.class);
	}
	
	private static CategoryDaoImpl categoryDao;
	
	public static CategoryDao getCategoryDao() {
		if (categoryDao == null) {
			categoryDao = new CategoryDaoImpl();
		}
		return categoryDao;
	}
}
