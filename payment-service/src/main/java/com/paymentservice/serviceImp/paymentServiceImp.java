package com.paymentservice.serviceImp;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.entity.Payment;
import com.paymentservice.repository.paymentRepository;
@Service
public class paymentServiceImp {
	
	@Autowired
	private paymentRepository paymentRepo;
	
	public Payment doPayment(Payment payment)
	{
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setAmount(payment.getAmount());
		System.out.println("paymentttttttt");
		System.out.println(payment);
		
		return paymentRepo.save(payment);
		
	}

	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
		
	}
}
