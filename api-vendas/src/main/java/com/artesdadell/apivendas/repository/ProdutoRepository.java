package com.artesdadell.apivendas.repository;

import com.artesdadell.apivendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
