package com.labanovich.notification.repository.mongo;


import com.labanovich.notification.model.Fine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FineRepository extends MongoRepository<Fine, String> {
}
