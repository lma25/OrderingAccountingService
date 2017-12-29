package com.ad.oas.repository;

import com.ad.oas.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String>{
    Address findByZipCode(String zipCode);
}
