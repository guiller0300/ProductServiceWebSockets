package com.example.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dto.NotificacionesDto;
import com.example.productservice.entity.Notificacion;
import com.example.productservice.service.NotificacionesService;

import reactor.core.publisher.Flux;
@RestController
@RequestMapping("notificaciones")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class NotificacionesController {
	
	@Autowired
	private NotificacionesService service;
	
	@GetMapping("all")
	public Flux<NotificacionesDto> all(){
		return this.service.getAll();
	}
	@GetMapping
	public Flux<Notificacion> byIdSocket(String subscriber){
		return this.service.getAllBySubscriber(subscriber);	
	}

}
