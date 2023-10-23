package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Carrinho;

import java.util.List;

public interface CarrinhoService {

    Carrinho save(Carrinho carrinho);

    Carrinho findById(Long id);

    List<Carrinho> findAll();

    void delete();
}
