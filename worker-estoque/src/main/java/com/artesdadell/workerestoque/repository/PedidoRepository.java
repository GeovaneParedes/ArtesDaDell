package com.artesdadell.workerestoque.repository;

import com.artesdadell.workerestoque.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
