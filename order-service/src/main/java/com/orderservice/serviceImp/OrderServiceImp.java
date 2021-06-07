package com.orderservice.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.Entity.Order;
import com.orderservice.common.TransactionRequest;
import com.orderservice.common.TransactionResponse;
import com.orderservice.repository.OrderRepository;
import com.orderservice.common.Payment;


@Service
public class OrderServiceImp {
	
	@Autowired
	private OrderRepository orderrepo;
	@Autowired
	private RestTemplate template;
	String response="";
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		Order order=request.getOrder();
	    Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		Payment paymentResponse=template.postForObject(getBaseUrl("PAYMENT-SERVICE")+"/payment/doPayment", payment, Payment.class);
	response= paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment and orderaddedto cart";
		System.out.println(paymentResponse);	 
	
			
		 
			 
		
		orderrepo.save(order);
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}

	private String getBaseUrl(String serviceId) {
	ServiceInstance instance=	loadBalancerClient.choose(serviceId);
	System.out.println(instance.getUri().toString());
		return instance.getUri().toString();
	}

}
