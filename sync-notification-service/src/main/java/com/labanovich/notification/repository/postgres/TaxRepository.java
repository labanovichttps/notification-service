package com.labanovich.notification.repository.postgres;


import com.labanovich.notification.model.Tax;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TaxRepository extends ReactiveCrudRepository<Tax, Long> {

    Flux<Tax> findAllByPersonName(String name);
}
