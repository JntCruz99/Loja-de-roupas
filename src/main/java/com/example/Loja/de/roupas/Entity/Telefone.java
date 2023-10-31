package com.example.Loja.de.roupas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.element.Name;

@Entity
@Table(name = "telefone_tb")
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String area;

    private String numero;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
