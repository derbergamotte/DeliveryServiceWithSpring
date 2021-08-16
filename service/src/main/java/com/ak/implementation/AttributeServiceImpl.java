package com.ak.implementation;

import com.ak.dto.AttributeDto;
import com.ak.entities.Attribute;
import com.ak.interfaces.AttributeService;
import com.ak.repository.interfaces.AttributeDao;
import com.ak.mappers.AttributeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl extends EntityServiceImpl<Attribute, AttributeDto> implements AttributeService {

    @Autowired
    private AttributeDao attributeDao;
    @Autowired
    private AttributeMapper attributeMapper;

    public AttributeDto update(Long id, AttributeDto dto) {
        if (dto.getId() == null) {
            return dto;
        }
        Attribute attribute = getEntityById(id);
        if (StringUtils.isNotEmpty(dto.getName())) {
            attribute.setName(dto.getName());
        }
        return attributeMapper.toDto(attributeDao.saveAndFlush(attribute));
    }
}
