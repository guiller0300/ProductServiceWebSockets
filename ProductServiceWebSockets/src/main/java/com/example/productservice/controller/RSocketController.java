package com.example.productservice.controller;

import java.time.Duration;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import com.example.productservice.dto.NotificacionDto;
import com.example.productservice.dto.ProductDto;
import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.entity.Notificacion;
import com.example.productservice.service.NotificacionesService;
import com.example.productservice.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class RSocketController {
	
	private final ProductService service;
	private final NotificacionesService notify;
	
	public RSocketController(ProductService service, NotificacionesService notify) {
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
	public Flux<Notificacion> getBySubscriber(int subscriber){
		/*subscriber = subscriber.replace("\"", "");  
		System.out.println(subscriber);*/
		return this.notify.getAllBySubscriber(subscriber)
				.defaultIfEmpty(new Notificacion());
	}
	@MessageMapping("insert.notification")
	public Mono<NotificacionDto> insertNotificacion(@Payload Mono<NotificacionDto> notificacion){
		return this.notify.insertNotificacion(notificacion);
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
