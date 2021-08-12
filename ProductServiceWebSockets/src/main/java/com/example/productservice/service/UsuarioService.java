package com.example.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.dto.UsuarioDto;
import com.example.productservice.entity.Usuario;
import com.example.productservice.repository.UsuarioRepository;
import com.example.productservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Flux<Usuario> getAllByDpto(String dpto){
		return this.repository.getAllByDpto(dpto);
	}

	public Flux<UsuarioDto> getAll(){
		return this.repository.findAll()
				.map(EntityDtoUtil::toDto);
	}
	
	public Mono<UsuarioDto> getUsuarioById(int id){
		return this.repository.findById(id)
				.map(EntityDtoUtil::toDto);
	}
}
