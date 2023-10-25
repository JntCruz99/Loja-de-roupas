package com.example.Loja.de.roupas.Entity;

import com.example.Loja.de.roupas.Entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private List<Item> itens;

    public Double getTotal() {
        total = 0.0;

        if (itens != null) {
            for (Item i : itens) {
                total += i.getProduto().getPreco() * i.getQtd();
            }
        }

        return total;
    }

    public void setItem(Item item){
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(item);
    }
}
