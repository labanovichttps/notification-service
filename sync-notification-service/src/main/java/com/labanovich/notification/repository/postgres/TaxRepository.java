package com.labanovich.notification.repository.postgres;


import com.labanovich.notification.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
}
