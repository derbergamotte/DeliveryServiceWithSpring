package com.ak.mappers;

import com.ak.entities.Order;
import com.ak.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "id", target = "id")
    OrderDto toDto(Order order);
    @Mapping(source = "id", target = "id")
    Order toEntity(OrderDto dto);
}
