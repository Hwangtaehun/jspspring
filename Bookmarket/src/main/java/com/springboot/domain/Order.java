package com.springboot.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Order {
	@Id @GeneratedValue
	private Long orderId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_id")
	private Shipping shipping;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_order_id")
	private Map<String, OrderItem> orderItems = new HashMap<>();
	private BigDecimal grandTotal;
}
