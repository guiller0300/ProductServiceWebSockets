package com.example.productservice.controller;

import java.time.Duration;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProductSocketController {
	
	private final ProductService service;
	
	public ProductSocketController(ProductService service) {
		this.service = service;
	}
	
	@MessageMapping("todos")
	public Flux<ProductDto> getAll(){
		return this.service.getAll();
	}   
	
	@MessageMapping("by.id")
	public Mono<ResponseEntity<ProductDto>> getProductById(ProductRequestDto request){
		return this.service.getProductById(request.getId())
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@MessageMapping("number.stream")
    public Flux<Integer> responseStream(Integer number) {
        return Flux.range(1, number)
                .delayElements(Duration.ofSeconds(1));
    }
	
}