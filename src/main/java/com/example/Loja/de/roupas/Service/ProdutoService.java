package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Produto;

import java.util.List;

public interface ProdutoService {

    Produto save(Produto produto);

    Produto findById(Long id);

    List<Produto> findAll();

    void delete();
}
