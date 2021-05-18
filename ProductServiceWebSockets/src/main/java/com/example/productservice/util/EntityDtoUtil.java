package com.example.productservice.util;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.example.productservice.dto.NotificacionDto;
import com.example.productservice.dto.ProductDto;
import com.example.productservice.dto.TransactionRequestDto;
import com.example.productservice.dto.TransactionResponseDto;
import com.example.productservice.dto.TransactionStatus;
import com.example.productservice.dto.UserDto;
import com.example.productservice.entity.Notificacion;
import com.example.productservice.entity.Products;
import com.example.productservice.entity.User;
import com.example.productservice.entity.UserTransaction;

public class EntityDtoUtil {
	
	//EntityDto Product
	public static ProductDto toDto(Products product) {
		ProductDto dto =  new ProductDto();
		BeanUtils.copyProperties(product, dto);
		return dto;
	}
	
	public static Products toEntity(ProductDto productDto) {
		Products product = new Products();
		BeanUtils.copyProperties(productDto, product);
		return product;
	}
	
	//EntityDto User
	public static UserDto toDto(User user) {
		UserDto dto =  new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}
	
	public static User toEntity(UserDto dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		return user;
	}
	
	//EntityDto UserTransaction
	public static UserTransaction toEntity(TransactionRequestDto requestDto) {
		UserTransaction ut = new UserTransaction();
		ut.setUserId(requestDto.getUserId());
		ut.setAmount(requestDto.getAmount());
		ut.setTransactionDate(LocalDateTime.now());
		return ut;
	}
	
	public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status) {
		TransactionResponseDto responseDto =  new TransactionResponseDto();
		responseDto.setUserId(requestDto.getUserId());
		responseDto.setAmount(requestDto.getAmount());
		responseDto.setStatus(status);
		return responseDto;
	}
	
	//EntityDto Notificaciones
	public static NotificacionDto toDto(Notificacion notificaciones) {
		NotificacionDto dto = new NotificacionDto();
		BeanUtils.copyProperties(notificaciones, dto);
		return dto;
	}
	
	public static Notificacion toEntity(NotificacionDto notificacionesDto) {
		Notificacion notificaciones = new Notificacion();
		BeanUtils.copyProperties(notificacionesDto, notificaciones);
		return notificaciones;
	}
}
