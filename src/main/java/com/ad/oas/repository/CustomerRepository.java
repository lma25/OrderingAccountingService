package com.ad.oas.repository;

import com.ad.oas.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByCustomerId(String customerId);
    Customer findByWechatId(String wechatId);
}
