package com.ak.mappers;

import com.ak.dto.StorageDto;
import com.ak.entities.Storage;
import org.mapstruct.Mapper;

@Mapper
public interface StorageMapper extends EntityMapper<Storage, StorageDto>{

}
