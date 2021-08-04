package com.ak.interfaces;

import com.ak.dto.BaseDto;

import java.util.Collection;

public interface EntityService<T extends BaseDto> {

    T add(T dto);

    T getById(Long id);

    Collection<T> getAll();

    void remove(Long id);

    T update(Long id, T dto);
}