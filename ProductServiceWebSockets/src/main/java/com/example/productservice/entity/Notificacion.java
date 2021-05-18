package com.example.productservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Notificacion {
	@Id
	private Integer id;
	private Integer subscriber;
	private String titulo, descripcion;
	private LocalDateTime fecha_inicio;
	private LocalDate fecha_final;
	private Boolean leido;
	
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
