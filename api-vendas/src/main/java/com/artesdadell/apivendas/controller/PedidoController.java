package com.artesdadell.apivendas.controller;

import com.artesdadell.apivendas.config.RabbitMQConfig;
import com.artesdadell.apivendas.model.Pedido;
import com.artesdadell.apivendas.repository.PedidoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired private PedidoRepository repository;

    @Autowired private RabbitTemplate rabbitTemplate;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        // 1. Define status inicial
        pedido.setStatus("AGUARDANDO_ESTOQUE");

        // 2. Salva no MySQL (Garante ID)
        Pedido salvo = repository.save(pedido);
        System.out.println("✅ Pedido salvo no banco: " + salvo.getId());

        // 3. Manda pro RabbitMQ (Assíncrono)
        // O RabbitTemplate usa o conversor JSON que configuramos
        rabbitTemplate.convertAndSend(RabbitMQConfig.FILA_PEDIDOS, salvo);
        System.out.println("🐰 Pedido enviado para a fila!");

        return salvo;
    }
}
