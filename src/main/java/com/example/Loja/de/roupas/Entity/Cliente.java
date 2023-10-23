package com.example.Loja.de.roupas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    private String cpf;

    @OneToMany(mappedBy = "cliente")
    private List<Carrinho> carrinhos;
}
