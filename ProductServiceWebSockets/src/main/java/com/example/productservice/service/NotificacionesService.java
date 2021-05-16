package com.example.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.dto.NotificacionesDto;
import com.example.productservice.dto.NotificacionesRequestDto;
import com.example.productservice.entity.Notificacion;
import com.example.productservice.repository.NotificacionesRepository;
import com.example.productservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;

@Service
public class NotificacionesService {
	
	@Autowired
	private NotificacionesRepository repository;
	
	public Flux<NotificacionesDto> getAll(){
		return this.repository.findAll()
				.map(EntityDtoUtil::toDto);
	}
	
	public Flux<Notificacion> getAllBySubscriber(String subscriber){
		System.out.println(subscriber);
		return this.repository.bySubscriber(subscriber);
	}
}
