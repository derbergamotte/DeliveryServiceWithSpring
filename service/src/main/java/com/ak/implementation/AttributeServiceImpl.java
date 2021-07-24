package com.ak.implementation;

import com.ak.dto.AttributeDto;
import com.ak.entities.Attribute;
import com.ak.interfaces.AttributeService;
import com.ak.interfaces.AttributeDao;
import com.ak.mappers.AttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeDao attributeDao;

    public AttributeDto add(AttributeDto attributeDto) {
            return AttributeMapper.INSTANCE.toDto(attributeDao.add(AttributeMapper.INSTANCE.toEntity(attributeDto)));
        }

    public AttributeDto getById(Long id) {
        return AttributeMapper.INSTANCE.toDto(attributeDao.get(id));

    }

    public AttributeDto getElseAdd(AttributeDto attributeDto){
        Attribute attribute = attributeDao.getAttributeByName(attributeDto.getName());
        if (attribute == null) {
            attributeDto = add(attributeDto);
        }
        return attributeDto;
    }
}
