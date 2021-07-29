package com.ak.mappers;

import com.ak.entities.Order;
import com.ak.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper extends EntityMapper<Order, OrderDto>{

}
