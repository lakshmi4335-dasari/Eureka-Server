package com.paymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paymentservice.entity.Payment;
@Repository
public interface paymentRepository extends MongoRepository<Payment, String>{

}
