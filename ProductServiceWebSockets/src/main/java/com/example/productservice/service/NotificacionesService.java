package com.example.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.dto.NotificacionDto;
import com.example.productservice.dto.NotificacionesRequestDto;
import com.example.productservice.entity.Notificacion;
import com.example.productservice.repository.NotificacionesRepository;
import com.example.productservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NotificacionesService {
	
	@Autowired
	private NotificacionesRepository repository;
	
	public Flux<NotificacionDto> getAll(){
		return this.repository.findAll()
				.map(EntityDtoUtil::toDto);
	}
	
	public Flux<Notificacion> getAllBySubscriber(int subscriber){
		return this.repository.bySubscriber(subscriber);
	}

	public Mono<NotificacionDto> insertNotificacion(Mono<NotificacionDto> notificacionDto) {
		return notificacionDto
				.map(EntityDtoUtil::toEntity)
				.flatMap(this.repository::save)
				.map(EntityDtoUtil::toDto);
	}
}
