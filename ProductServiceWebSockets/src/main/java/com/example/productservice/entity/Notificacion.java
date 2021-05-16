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
	private Integer idproduct;
	@Column
	private String usuario, titulo, descripcion, subscriber;
	private LocalDate fecha_inicio;
	private LocalDate fecha_final;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(Integer idproduct) {
		this.idproduct = idproduct;
	}
	public String getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(LocalDate fecha_final) {
		this.fecha_final = fecha_final;
	}
}
