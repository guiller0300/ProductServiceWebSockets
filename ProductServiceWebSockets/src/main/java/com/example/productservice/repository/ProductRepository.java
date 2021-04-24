package com.example.productservice.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.entity.Products;

import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Products, Integer> {
	
	@Query
	("insert into products values (null, :product, :price, :subscriber)")
	Mono<Boolean> insert (String product, int price, String subscriber);

}
