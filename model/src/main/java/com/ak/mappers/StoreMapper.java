package com.ak.mappers;

import com.ak.dto.StoreDto;
import com.ak.entities.Store;
import org.mapstruct.Mapper;

@Mapper
public interface StoreMapper extends EntityMapper<Store, StoreDto>{

}
