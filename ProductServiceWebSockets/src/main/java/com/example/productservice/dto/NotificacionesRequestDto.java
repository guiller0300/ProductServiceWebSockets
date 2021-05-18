package com.example.productservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class NotificacionesRequestDto {
	
	private Integer id;
	private Integer subscriber;
	private String titulo, descripcion;
	private LocalDateTime fecha_inicio;
	private LocalDate fecha_final;
	private Boolean leido;
	
	public NotificacionesRequestDto (int id) {
		super();
		this.id = id;
	}
	public NotificacionesRequestDto() {}
	
	public Integer getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Integer subscriber) {
		this.subscriber = subscriber;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescription(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Boolean getLeido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(LocalDate fecha_final) {
		this.fecha_final = fecha_final;
	}
}
