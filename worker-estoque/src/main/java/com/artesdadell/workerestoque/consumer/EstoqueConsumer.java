package com.artesdadell.workerestoque.consumer;

import com.artesdadell.workerestoque.model.Pedido;
import com.artesdadell.workerestoque.repository.PedidoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @Autowired private PedidoRepository repository;

    @RabbitListener(queues = "fila-pedidos")
    public void processarPedido(Pedido pedido) {
        System.out.println("📦 [ESTOQUE] Processando pedido: " + pedido.getProduto());

        // Atualiza status
        pedido.setStatus("APROVADO_PELA_DELL");
        repository.save(pedido);

        System.out.println("✅ Pedido " + pedido.getId() + " aprovado!");
    }
}
