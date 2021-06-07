package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.Entity.Order;
import com.orderservice.common.TransactionRequest;
import com.orderservice.common.TransactionResponse;
import com.orderservice.serviceImp.OrderServiceImp;
import com.paymentservice.entity.Payment;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderServiceImp orderservice;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		
		return orderservice.saveOrder(request);
		
	}

}
