package com.kd.microservices.tmp.tms.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kd.microservices.tmp.tms.constant.Constants;

@Configuration
public class MessagingConfig {

	@Bean
	public Queue queue() {
		return new Queue(Constants.QUEUE);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(Constants.EXCHANGE);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Constants.ROUTING_KEY);
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory factory) {
		final RabbitTemplate RABBIT_TEMPLATE = new RabbitTemplate(factory);
		RABBIT_TEMPLATE.setMessageConverter(converter());
		return RABBIT_TEMPLATE;
	}
}
