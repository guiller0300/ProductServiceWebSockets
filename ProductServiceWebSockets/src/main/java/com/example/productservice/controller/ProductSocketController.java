package com.example.productservice.controller;

import java.time.Duration;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.entity.Notificacion;
import com.example.productservice.service.NotificacionesService;
import com.example.productservice.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProductSocketController {
	
	private final ProductService service;
	private final NotificacionesService notify;
	
	public ProductSocketController(ProductService service, NotificacionesService notify) {
		this.service = service;
		this.notify = notify;
	}
	
	@MessageMapping("todos")
	public Flux<ProductDto> getAll(){
		return this.service.getAll();
	}   
	
	@MessageMapping("by.id")
	public Mono<ProductDto> getProductById(ProductRequestDto request){
		return this.service.getProductById(request.getId())
				.defaultIfEmpty(new ProductDto());
	}
	
	@MessageMapping("by.subscriber")
	public Flux<Notificacion> getBySubscriber(@Payload String subscriber){
		return this.notify.getAllBySubscriber(subscriber)
				.defaultIfEmpty(new Notificacion());
	}
	@MessageMapping("insert.product")
	public Mono<ProductDto> insertProduct(@Payload Mono<ProductDto> product){
		return this.service.insertProduct(product);
	}
	
	@MessageMapping("number.stream")
    public Flux<Integer> responseStream(Integer number) {
        return Flux.range(1, number)
                .delayElements(Duration.ofSeconds(1));
    }
	
}
