package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Produto;
import com.example.Loja.de.roupas.Repository.ProdutoRepository;
import com.example.Loja.de.roupas.Service.ProdutoService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto save(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public void delete() {

    }
}
