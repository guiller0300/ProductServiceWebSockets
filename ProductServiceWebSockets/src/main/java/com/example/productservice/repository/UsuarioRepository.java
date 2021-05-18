package com.example.productservice.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.productservice.entity.Usuario;

import reactor.core.publisher.Flux;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Integer>{
	
	@Query("select * from usuario where departamento = :dpto")
	Flux<Usuario> getAllByDpto(String dpto);
}
