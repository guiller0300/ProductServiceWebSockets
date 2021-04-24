package com.example.productservice.websockets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ReactiveWebSocketConfiguration {

    private WebSocketHandler webSocketHandler;
    private ReactiveWebSocketConfiguration productsWebSocketHandler;
    public ReactiveWebSocketConfiguration(ReactiveWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @Bean
    public HandlerMapping webSocketHandlerMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/greetings", webSocketHandler);

        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        handlerMapping.setUrlMap(map);
        handlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return handlerMapping;
    }
    
    @Bean
	public WebSocketHandlerAdapter handlerAdapter(WebSocketService webSocketService) {
		return new WebSocketHandlerAdapter(webSocketService);
	}
	@Bean
	public WebSocketService webSocketService() {
		// TomcatRequestUpgradeStrategy strategy = new TomcatRequestUpgradeStrategy();
		ReactorNettyRequestUpgradeStrategy strategy = new ReactorNettyRequestUpgradeStrategy();
		// strategy.setMaxSessionIdleTimeout(0L); //for Tomcat server
		return new HandshakeWebSocketService(strategy);
	}

}
