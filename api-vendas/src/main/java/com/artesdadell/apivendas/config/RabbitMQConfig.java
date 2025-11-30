package com.artesdadell.apivendas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_PEDIDOS = "fila-pedidos";

    // Cria a fila automaticamente
    @Bean
    public Queue queue() {
        return new Queue(FILA_PEDIDOS, true);
    }

    // Permite enviar objetos Java como JSON automaticamente
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
