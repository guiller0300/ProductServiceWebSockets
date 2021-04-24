package com.example.productservice.websockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import com.example.productservice.entity.Products;
import com.example.productservice.repository.ProductRepository;
//import com.kojotdev.blog.webfluxvuewebsocket.GreetingsPublisher;
//import com.kojotdev.blog.webfluxvuewebsocket.GreetingsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveWebSocketHandler implements WebSocketHandler {
	
	@Autowired
	private ProductRepository repository;
    //private final Flux<String> publisher;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(
        		session.receive()
        		.map(subscriber -> new Products(subscriber.getPayloadAsText()))
        		.flatMap(repository::save)
        		.map(us -> session.textMessage(us.getDescription())));

        /*final Flux<WebSocketMessage> message = publisher
                .map(greetings -> webSocketSession.textMessage(greetings));

        return webSocketSession.send(message);*/
    }
}
