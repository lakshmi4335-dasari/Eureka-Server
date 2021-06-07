package com.paymentservice.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.entity.Payment;
import com.paymentservice.serviceImp.paymentServiceImp;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private paymentServiceImp paymentservice;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		return paymentservice.doPayment(payment);
		
	}
	
	

}
