package com.ak.implementation;

import java.util.List;

import com.ak.entities.BaseEntity;
import com.ak.interfaces.GenericDao;
import com.sun.xml.bind.v2.TODO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

public abstract class GenericDaoImpl<T extends BaseEntity> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> clazz;

    public GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getGenericClass() {
        return this.clazz;
    }

    @Transactional
    public T add(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public T get(Long id) {
        return entityManager.find(getGenericClass(), id);
    }

    @Transactional
    public T update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

    @Transactional
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public List<T> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(getGenericClass());
        Root<T> root = query.from(getGenericClass());
        query.select(root);
        TypedQuery<T> result = entityManager.createQuery(query);
        return result.getResultList();
    }

}
