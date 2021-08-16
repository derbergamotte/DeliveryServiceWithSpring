package com.ak.implementation;

import com.ak.dto.BaseDto;
import com.ak.entities.BaseEntity;
import com.ak.interfaces.EntityService;
import com.ak.repository.interfaces.GenericDao;
import com.ak.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class EntityServiceImpl<E extends BaseEntity, T extends BaseDto> implements EntityService<T> {

    @Autowired
    private GenericDao<E> genericDao;
    @Autowired
    private EntityMapper<E, T> entityMapper;

    public T add(T dto) {
        return entityMapper.toDto(genericDao.save(entityMapper.toEntity(dto)));
    }

    public T getById(Long id) {
        return entityMapper.toDto(getEntityById(id));
    }

    public Collection<T> getAll() {
        return genericDao.findAll().stream().map(entityMapper::toDto).collect(Collectors.toSet());
    }

    public void remove(Long id) {
        genericDao.delete(getEntityById(id));
    }

    protected E getEntityById(Long id) {
        return genericDao.findById(id).orElse(null);
    }
}
