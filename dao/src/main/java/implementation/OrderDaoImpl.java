package implementation;

import entities.Order;
import interfaces.OrderDao;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	
	private OrderDaoImpl() {
		super(Order.class);
	}

	private static OrderDaoImpl orderDao;

	public static OrderDao getOrderDao() {
		if (orderDao == null) {
			orderDao = new OrderDaoImpl();
		}
		return orderDao;
	}
}
