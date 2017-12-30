package com.ad.oas.repository;

import com.ad.oas.model.NextIndex;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NextIndexRepository extends MongoRepository<NextIndex, Long> {
}
