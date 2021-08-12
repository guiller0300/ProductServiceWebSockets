package com.example.productservice.repository;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.entity.Notificacion;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface NotificacionesRepository extends R2dbcRepository<Notificacion, Integer> {

@Query
(value = "select * from notificacion where subscriber = :subscriber or subscriber = 0")
Flux<Notificacion> bySubscriber(int subscriber);

@Modifying
@Query
(value="UPDATE notificacion SET leido = 1 WHERE (id = :id) and subscriber = :subscriber")
Mono<Notificacion> setReadNotification(int id, int subscriber);
}
