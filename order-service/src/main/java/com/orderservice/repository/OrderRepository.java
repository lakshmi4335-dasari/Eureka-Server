package com.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.Entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

}
