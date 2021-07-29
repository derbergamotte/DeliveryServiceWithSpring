package com.ak.implementation;

import java.util.ArrayList;
import java.util.List;

import com.ak.entities.BaseEntity;
import com.ak.interfaces.GenericDao;

public abstract class GenericDaoImpl<T extends BaseEntity> implements GenericDao<T> {

    private final List<T> collection = new ArrayList<>();
    private Long index = 0L;

    private final Class<T> clazz;

    public GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getGenericClass() {
        return this.clazz;
    }

    @Override
    public T add(T entity) {
        index = index++;
        entity.setId(index);
        collection.add(Math.toIntExact(index), entity);
        return entity;
    }

    @Override
    public T get(Long id) {
        return collection.get(Math.toIntExact(id));
    }

    @Override
    public T update(T entity) {
        collection.add(Math.toIntExact(entity.getId()), entity);
        return entity;
    }

    @Override
    public void remove(Long id) {
        collection.remove(Math.toIntExact(id));
    }

    @Override
    public List<T> getAll() {
        return collection;
    }
}
