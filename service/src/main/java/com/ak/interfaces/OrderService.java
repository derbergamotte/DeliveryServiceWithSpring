package com.ak.interfaces;

import com.ak.dto.OrderDto;

public interface OrderService {

    OrderDto add(OrderDto orderDto);

    OrderDto getById(Long id);
}
