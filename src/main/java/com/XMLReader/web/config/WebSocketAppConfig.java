package com.XMLReader.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.XMLReader.web.controller.NotifyAspect;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketAppConfig extends AbstractWebSocketMessageBrokerConfigurer {

	/**
	 * We actually have to add an endpoint that can be used by our client to connect on 
	 * and we also have to define the topic prefix that can be used to publish/subscribe. 
	 * In this case our configuration
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/topic");
	    config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/notify").withSockJS();
	}
	
}
