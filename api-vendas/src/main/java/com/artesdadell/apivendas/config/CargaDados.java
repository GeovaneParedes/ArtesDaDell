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
        // Só carrega se o banco estiver VAZIO
        if (produtoRepo.count() == 0) {

            // Produto 1
            produtoRepo.save(
                    new Produto(
                            "Kit Semaninha Bordado",
                            "7 Panos de prato bordados com os dias da semana. Algodão 100%.",
                            new BigDecimal("85.90"),
                            "/img/fa5b32d9512d4288907281d5dfa775ef.jpg")); // Caminho local

            // Produto 2
            produtoRepo.save(
                    new Produto(
                            "Toalha de Rosto Floral",
                            "Toalha aveludada com barrado em guipir e estampa floral.",
                            new BigDecimal("45.00"),
                            "/img/toalha-de-rosto-floral-rosa_312913_600_1.jpg"));

            // Produto 3
            produtoRepo.save(
                    new Produto(
                            "Pano de Copa Galinha",
                            "Pano de prato com estampa divertida de galinha e bico de crochê.",
                            new BigDecimal("22.50"),
                            "/img/62a87181809ab50319862a87181809b0.jpg"));

            // Produto 4
            produtoRepo.save(
                    new Produto(
                            "Caminho de Mesa Renda",
                            "Caminho de mesa de 2 metros em linho rústico com renda.",
                            new BigDecimal("120.00"),
                            "/img/caminho-de-mesa-renda.jpeg"));

            // Produto 5
            produtoRepo.save(
                    new Produto(
                            "Jogo Americano (4un)",
                            "Kit com 4 lugares americanos impermeáveis estampa geométrica.",
                            new BigDecimal("60.00"),
                            "/img/jogo-americano.png"));

            // Produto 6
            produtoRepo.save(
                    new Produto(
                            "Peso de Porta Coruja",
                            "Peso de porta artesanal em tecido no formato de coruja.",
                            new BigDecimal("35.00"),
                            "/img/peso-de-porta-corujinha-peso-de-porta-coruja.jpg"));

            System.out.println("✅ Carga Inicial: 6 Produtos cadastrados no banco!");
        }
    }
}
