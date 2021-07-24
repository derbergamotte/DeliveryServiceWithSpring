package com.ak.implementation;

import com.ak.dto.OrderDto;
import com.ak.entities.Order;
import com.ak.interfaces.OrderDao;
import com.ak.interfaces.OrderService;
import com.ak.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	public OrderDto add(OrderDto orderDto) {
		return OrderMapper.INSTANCE.toDto(orderDao.add(OrderMapper.INSTANCE.toEntity(orderDto)));
	}

	public OrderDto getById(Long id) {
		return OrderMapper.INSTANCE.toDto(getEntity(id));
	}

	private Order getEntity(Long id) {
		return orderDao.get(id);
	}
}