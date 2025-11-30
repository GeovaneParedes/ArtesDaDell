package com.artesdadell.apivendas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String produto; // Ex: "Kit Semaninha"
    private Integer quantidade;

    private String status; // AGUARDANDO, APROVADO, CANCELADO

    // Construtores
    public Pedido() {}

    public Pedido(String cliente, String produto, Integer quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.status = "AGUARDANDO"; // Status inicial padrão
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString para facilitar o log no console
    @Override
    public String toString() {
        return "Pedido{id=" + id + ", cliente='" + cliente + "', produto='" + produto + "'}";
    }
}
