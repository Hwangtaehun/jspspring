package com.springboot.repository;

import java.util.HashMap;
import java.util.Map;

import com.springboot.domain.Order;

public class OrderRepositoryImpl implements OrderRepository {
	private Map<Long, Order> listOfOrders;
	private long nextOrderId;

	public OrderRepositoryImpl() {
		// TODO Auto-generated constructor stub
		listOfOrders = new HashMap<Long, Order>();
		nextOrderId = 2000;
	}

	@Override
	public Long saveOrder(Order order) {
		// TODO Auto-generated method stub
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
		return order.getOrderId();
	}

	private Long getNextOrderId() {
		// TODO Auto-generated method stub
		return nextOrderId++;
	}

}
