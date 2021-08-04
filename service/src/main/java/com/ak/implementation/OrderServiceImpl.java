package com.ak.implementation;

import com.ak.dto.OrderDto;
import com.ak.entities.Order;
import com.ak.interfaces.OrderDao;
import com.ak.interfaces.OrderService;
import com.ak.mappers.OrderMapper;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends EntityServiceImpl<Order, OrderDto> implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public OrderDto update(Long id, OrderDto dto) {
		throw new NotImplementedException();
	}

}