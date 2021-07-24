package com.ak.mappers;

import com.ak.dto.StoreDto;
import com.ak.entities.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Mapping(source = "id", target = "id")
    StoreDto toDto(Store entity);

    Collection<StoreDto> toDto(Collection<Store> stores);

    Store toEntity(StoreDto dto);
}
