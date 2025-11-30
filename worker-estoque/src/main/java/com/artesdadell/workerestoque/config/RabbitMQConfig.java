package com.artesdadell.workerestoque.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_PEDIDOS = "fila-pedidos"; // Constante

    @Bean
    public Queue queue() {
        return new Queue(FILA_PEDIDOS, true);
    }

    // ---------------------

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
