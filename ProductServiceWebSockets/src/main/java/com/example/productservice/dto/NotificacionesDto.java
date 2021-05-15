package com.example.productservice.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NotificacionesDto {
	private Integer id, idproduct;
	private String usuario, titulo, descripcion, subscriber;
	private LocalDate fecha_inicio;
	private LocalDate fecha_final;
	
	
	public NotificacionesDto(Integer id, Integer idproduct, String subscriber, String usuario, String titulo,
			String descripcion,LocalDate fecha_inicio, LocalDate fecha_final) {
		super();
		this.id = id;
		this.idproduct = idproduct;
		this.subscriber = subscriber;
		this.usuario = usuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
	}
	
	public NotificacionesDto() {}
	
	public NotificacionesDto id(NotificacionesDto notificaciones) {
		return new NotificacionesDto(notificaciones.getId(),
				notificaciones.getIdproduct(),
				notificaciones.getSubscriber(),
				notificaciones.getUsuario(),
				notificaciones.getTitulo(),
				notificaciones.getDescripcion(),
				notificaciones.getFecha_inicio(),
				notificaciones.getFecha_final());
	}
	
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
