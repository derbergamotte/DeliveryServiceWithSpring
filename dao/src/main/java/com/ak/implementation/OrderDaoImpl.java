package com.ak.implementation;

import com.ak.entities.Order;
import com.ak.interfaces.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	
	OrderDaoImpl() {
		super(Order.class);
	}
}
