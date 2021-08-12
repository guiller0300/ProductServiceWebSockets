package com.example.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dto.UsuarioDto;
import com.example.productservice.entity.Usuario;
import com.example.productservice.service.UsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("usuario")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public Flux<Usuario> byIdSocketDpto(@RequestParam String dpto){
		return this.service.getAllByDpto(dpto);
	}
	
	@GetMapping("all")
	public Flux<UsuarioDto> getAll(){
		return this.service.getAll();	
	}
	
	@GetMapping("{id}")
	public Mono<ResponseEntity<UsuarioDto>> getUsuarioById(@PathVariable int id){
		return this.service.getUsuarioById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
