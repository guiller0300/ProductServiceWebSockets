package com.example.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.dto.UserDto;
import com.example.productservice.repository.UserRepository;
import com.example.productservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Flux<UserDto> all(){
		return this.userRepository.findAll()
		.map(EntityDtoUtil::toDto);
	}
	
	public Mono<UserDto> getUserById(final int userId){
		return this.userRepository.findById(userId)
				.map(EntityDtoUtil::toDto);
	}
	
	public Mono<UserDto> createUser(Mono<UserDto> userDtoMono){
		return userDtoMono
				.map(EntityDtoUtil::toEntity)
				.flatMap(this.userRepository::save)
				.map(EntityDtoUtil::toDto);
	}
	
	public Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono){
		return this.userRepository.findById(id)  //Verificamos que exista ese id en el repositorio
			.flatMap(u -> userDtoMono //Checamos que también en el DTO este presente
					.map(EntityDtoUtil::toEntity) //Lo transformamos a entidad
					.doOnNext(e -> e.setId(id))) //Después de obtenida la entidad le proporcionamos el ID
			.flatMap(this.userRepository::save) //Guardamos
			.map(EntityDtoUtil::toDto); //Y regresamos la información al DTO
	}
	
	public Mono<Void> deleteUser(int id){
		return this.userRepository.deleteById(id);
	}
}
