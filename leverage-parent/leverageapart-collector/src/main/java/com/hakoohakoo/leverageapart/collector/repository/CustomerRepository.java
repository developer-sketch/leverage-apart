package com.hakoohakoo.leverageapart.collector.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.hakoohakoo.leverageapart.collector.model.Customer;

import reactor.core.publisher.Mono;

public interface CustomerRepository extends R2dbcRepository<Customer, Integer>{
	@Query("SELECT * FROM customer WHERE name =  :name")
	Mono<Customer> findByName(String name);
}
