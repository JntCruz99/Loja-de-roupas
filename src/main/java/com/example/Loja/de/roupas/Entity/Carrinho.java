package com.example.Loja.de.roupas.Entity;

import com.example.Loja.de.roupas.Entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_carrinho")
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;

    private Status status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name="produto_no_carrinho", joinColumns=
            {@JoinColumn(name="carrinho_id")}, inverseJoinColumns=
            {@JoinColumn(name="produto_id")})
    private List<Produto> produtos;
}
