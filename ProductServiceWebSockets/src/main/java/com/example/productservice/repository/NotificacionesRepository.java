package com.example.productservice.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.entity.Notificacion;

import reactor.core.publisher.Flux;

@Repository
public interface NotificacionesRepository extends R2dbcRepository<Notificacion, Integer> {

@Query
(value = "select * from notificacion where subscriber = :subscriber or subscriber is null")
Flux<Notificacion> bySubscriber(String subscriber);

}
