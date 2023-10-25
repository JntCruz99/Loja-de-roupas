package com.example.Loja.de.roupas.Entity;

import com.example.Loja.de.roupas.Entity.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_pedido")
@Data
public class Pedido {

    private Endereco endereco;

    private Double valor;

    private Double frete;

    private String formaPagamento;

    private Carrinho carrinho;

    private Usuario usuario;

    private Status status;
}
