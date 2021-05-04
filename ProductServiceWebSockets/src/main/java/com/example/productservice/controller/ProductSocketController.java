package com.example.productservice.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.service.ProductService;

import reactor.core.publisher.Flux;

public class ProductSocketController {
	
	private final ProductService service;
	
	public ProductSocketController(ProductService service) {
		this.service = service;
	}
	
	@MessageMapping("todos")
	public Flux<ProductDto> getAll(){
		return service.getAll();
	}
}
