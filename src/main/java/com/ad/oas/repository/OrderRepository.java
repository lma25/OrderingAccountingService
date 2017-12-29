package com.ad.oas.repository;

import com.ad.oas.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByOrderId(String orderId);
    List<Order> findByCustomerId(String customerId);
}
