package com.example.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {
	
	private final Mono<RSocketRequester> requester;
	private final ProductService service;
	
	
	public ProductController(ProductService service, Mono<RSocketRequester> requester) {
		this.service = service;
		this.requester = requester;
	}
	
	@GetMapping(value = "all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ProductDto> all(){
		return this.service.getAll();
	}
	
	@GetMapping(value = "/socket/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ProductDto> allBySocket(){
		return this.requester.flatMapMany(r -> r.route("todos")
				.data(new ProductRequestDto())
				.retrieveFlux(ProductDto.class));
	}
	
	@GetMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> getProductById(int id){
		return this.service.getProductById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<ProductDto> insertProductTable(@RequestBody Mono<ProductDto> productDtoMono){
		return this.service.insertProduct(productDtoMono);
	}
	
	@PutMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable int id, @RequestBody Mono<ProductDto> productMonoDto) {
		return this.service.updateProduct(id, productMonoDto)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping
	public Mono<Void> deleteProduct(@PathVariable int id){
		return this.service.deleteProduct(id);
	}
	
	
}
