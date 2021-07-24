package com.ak.mappers;

import com.ak.dto.StorageDto;
import com.ak.entities.Storage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface StorageMapper {

    StorageMapper INSTANCE = Mappers.getMapper(StorageMapper.class);

    @Mapping(source = "id", target = "id")
    StorageDto toDto(Storage entity);

    Collection<StorageDto> toDto(Collection<Storage> storages);

    Storage toEntity(StorageDto dto);
}
