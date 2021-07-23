package interfaces;

import java.util.Base64;
import java.util.List;

import entities.BaseEntity;

public interface GenericDao<T extends BaseEntity> {
	
	Class<T> getGenericClass();
	
	T add(T entity);
	
	T get(Long id);
	
	void update (T entity);
	
	void remove (Long id);
	
	List<T> getAll();

}
