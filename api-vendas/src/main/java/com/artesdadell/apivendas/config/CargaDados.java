package com.artesdadell.apivendas.config;

import com.artesdadell.apivendas.model.Produto;
import com.artesdadell.apivendas.repository.ProdutoRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CargaDados implements CommandLineRunner {

    @Autowired private ProdutoRepository produtoRepo;

    @Override
    public void run(String... args) throws Exception {
        if (produtoRepo.count() == 0) {
            produtoRepo.save(
                    new Produto(
                            "Kit Semaninha",
                            "7 Panos de prato bordados com os dias da semana.",
                            new BigDecimal("85.90"),
                            "https://http2.mlstatic.com/D_NQ_NP_767590-MLB46244795907_062021-O.webp"));
            produtoRepo.save(
                    new Produto(
                            "Toalha Floral",
                            "Toalha de rosto com acabamento em renda guipir.",
                            new BigDecimal("45.00"),
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqYVqGvQWGyYI9Xl7QyXqgKqYqqGqYqqGqYq&s"));
            produtoRepo.save(
                    new Produto(
                            "Caminho de Mesa",
                            "2 metros, tecido linho rústico.",
                            new BigDecimal("120.00"),
                            "https://via.placeholder.com/400x300/e11d48/ffffff?text=Caminho+Mesa"));
        }
    }
}
