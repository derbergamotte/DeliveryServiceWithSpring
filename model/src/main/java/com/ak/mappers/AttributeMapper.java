package com.ak.mappers;

import com.ak.dto.AttributeDto;
import com.ak.entities.Attribute;
import org.mapstruct.Mapper;

@Mapper
public interface AttributeMapper extends EntityMapper<Attribute, AttributeDto> {

}
