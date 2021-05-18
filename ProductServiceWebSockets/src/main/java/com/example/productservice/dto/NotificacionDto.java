package com.example.productservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NotificacionDto {
	@Id
	private Integer id;
	private Integer subscriber;
	private String titulo, descripcion;
	private LocalDateTime fecha_inicio;
	private LocalDate fecha_final;
	private Boolean leido;
	
	public NotificacionDto() {}
		
	public NotificacionDto(Integer id, Integer subscriber, String titulo, String descripcion,
			LocalDateTime fecha_inicio, LocalDate fecha_final, Boolean leido) {
		super();
		this.id = id;
		this.subscriber = subscriber;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.leido = leido;
	}

	public NotificacionDto id(NotificacionDto notificaciones) {
		return new NotificacionDto(notificaciones.getId(),
				notificaciones.getSubscriber(),
				notificaciones.getTitulo(),
				notificaciones.getDescripcion(),
				notificaciones.getFecha_inicio(),
				notificaciones.getFecha_final(),
				notificaciones.getLeido());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Integer subscriber) {
		this.subscriber = subscriber;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String description) {
		this.descripcion = description;
	}
	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(LocalDate fecha_final) {
		this.fecha_final = fecha_final;
	}
	public Boolean getLeido() {
		return leido;
	}
	public void setLeido(Boolean leido) {
		this.leido = leido;
	}
}
