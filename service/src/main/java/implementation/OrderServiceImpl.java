package implementation;

import java.util.Optional;

import dto.OrderDto;
import entities.Order;
import interfaces.OrderDao;
import interfaces.OrderService;
import mappers.OrderMapper;

public class OrderServiceImpl implements OrderService {

	private final OrderDao orderDao = OrderDaoImpl.getOrderDao();
	private static OrderServiceImpl orderService;

	private OrderServiceImpl() {
	}

	public static OrderServiceImpl getOrderService() {
		if (orderService == null) {
			orderService = new OrderServiceImpl();
		}
		return orderService;
	}

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