package com.example.Loja.de.roupas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_produto")
@Data
public class Produto {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String img;

    private String disc;

    private Double preco;

    private int qtd;

    @JsonIgnore
    @ManyToMany(mappedBy="produtos")
    private List<Carrinho> carrinho;

    @ManyToMany
    @JoinTable(name="categorias_do_produto", joinColumns=
            {@JoinColumn(name="produto_id")}, inverseJoinColumns=
            {@JoinColumn(name="categoria_id")})
    private List<Categoria> categorias;
}
