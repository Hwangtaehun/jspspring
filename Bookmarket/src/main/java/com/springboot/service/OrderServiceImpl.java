package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.domain.Book;
import com.springboot.domain.Order;
import com.springboot.repository.BookRepository;
import com.springboot.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {
	@Autowired
	private BookRepository bookRespository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void confirmOrder(String bookId, long quantity) {
		// TODO Auto-generated method stub
		Book bookById = bookRespository.getBookById(bookId);
		
		if(bookById.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException("품절입니다. 사용 가능한 재고수:" + bookById.getUnitsInStock());
		}
		
		bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
	}

	@Override
	public Long saveOrder(Order order) {
		// TODO Auto-generated method stub
		Long orderId = orderRepository.saveOrder(order);
		return orderId;
	}

}
