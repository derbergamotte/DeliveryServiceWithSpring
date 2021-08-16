package com.ak.repository.interfaces;

import com.ak.entities.Order;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrderDao extends GenericDao<Order> {

}
