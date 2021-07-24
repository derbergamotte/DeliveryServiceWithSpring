package com.ak.interfaces;

import com.ak.dto.AttributeDto;

public interface AttributeService {

    AttributeDto add(AttributeDto attributeDto);

    AttributeDto getById(Long id);

    AttributeDto getElseAdd(AttributeDto attributeDto);
}