package com.example.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.entity.Usuario;
import com.example.productservice.repository.UsuarioRepository;

import reactor.core.publisher.Flux;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Flux<Usuario> getAllByDpto(String dpto){
		return this.repository.getAllByDpto(dpto);
	}
}
