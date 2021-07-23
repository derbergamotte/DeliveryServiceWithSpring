package interfaces;

import dto.OrderDto;

public interface OrderService {

    OrderDto add(OrderDto orderDto);

    OrderDto getById(Long id);
}
