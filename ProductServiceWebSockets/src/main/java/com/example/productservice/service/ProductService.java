package com.example.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private Sinks.Many<ProductDto> sink;
	
	public Flux<ProductDto> getAll(){
		return this.repository.findAll()
		.map(EntityDtoUtil::toDto);
	}
	
	public Mono<ProductDto> getProductById(final int id){
			return this.repository.findById(id)
					.map(EntityDtoUtil::toDto);
	}
	
	public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono){
		return productDtoMono
				.map(EntityDtoUtil::toEntity)
				.flatMap(this.repository::save)
				.map(EntityDtoUtil::toDto)
				.doOnNext(this.sink::tryEmitNext);
	}
	public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono, String subscriber){
		return  productDtoMono
				.map(EntityDtoUtil::toEntity)
				.flatMap(this.repository::save)
				.map(EntityDtoUtil::toDto)
				.doOnNext(this.sink::tryEmitNext);
	}
	public Mono<ProductDto> updateProduct(int id, Mono<ProductDto> productDtoMono){
		return this.repository.findById(id)
				.flatMap(p -> productDtoMono
						.map(EntityDtoUtil::toEntity)
						.doOnNext(e -> e.setId(id)))
				.flatMap(this.repository::save)
				.map(EntityDtoUtil::toDto);
	}
	
	public Mono<Void> deleteProduct (int id) {
		return this.repository.deleteById(id);
	}

}
