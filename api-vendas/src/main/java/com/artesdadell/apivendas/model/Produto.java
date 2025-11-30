package com.artesdadell.apivendas.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 1000) // Descrição longa
    private String descricao;

    private BigDecimal preco; // BigDecimal é obrigatório para dinheiro!
    private String imagemUrl; // Pode ser "/img/foto1.jpg" ou URL externa

    public Produto() {}

    public Produto(String nome, String descricao, BigDecimal preco, String imagemUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
    }

    // Getters e Setters (Pode gerar na IDE ou usar Lombok se preferir)
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
