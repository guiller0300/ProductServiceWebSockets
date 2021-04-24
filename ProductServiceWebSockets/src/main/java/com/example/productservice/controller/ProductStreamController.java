package com.example.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dto.ProductDto;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("product")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductStreamController {
	
	@Autowired
	private Flux<ProductDto> flux;
	
	//General Stream
	@GetMapping(value ="stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ProductDto> getProductUpdates(){
		return this.flux;
		
	}
	
	//Specific Stream
	@GetMapping(value = "streams", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ProductDto> getProductPriceUpdate(@RequestParam String subscriber){
		return this.flux
				.filter(dto -> dto.getSubscriber().equals(subscriber));
	}
}
