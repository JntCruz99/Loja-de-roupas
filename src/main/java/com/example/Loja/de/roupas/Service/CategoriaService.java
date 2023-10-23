package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria save(Categoria categoria);

    Categoria findById(Long id);

    List<Categoria> findAll();

    void delete();
}
