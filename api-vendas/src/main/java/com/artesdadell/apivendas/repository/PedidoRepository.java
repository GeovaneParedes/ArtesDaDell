package com.artesdadell.apivendas.repository;

import com.artesdadell.apivendas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
