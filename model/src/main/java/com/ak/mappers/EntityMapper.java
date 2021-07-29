package com.ak.mappers;

import com.ak.dto.BaseDto;
import com.ak.entities.BaseEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

public interface EntityMapper<E extends BaseEntity, T extends BaseDto>{

    T toDto(E entity);

    Collection<T> toDto(Collection<E> entities);

    E toEntity(T dto);
}
