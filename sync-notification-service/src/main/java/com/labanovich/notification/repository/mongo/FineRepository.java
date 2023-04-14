package com.labanovich.notification.repository.mongo;


import com.labanovich.notification.model.Fine;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface FineRepository extends ReactiveMongoRepository<Fine, String> {

    Flux<Fine> findAllByPersonName(String personName);
}
