package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Repository.CarrinhoRepository;
import com.example.Loja.de.roupas.Service.CarrinhoService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Override
    public Carrinho save(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
        return carrinho;
    }

    @Override
    public Carrinho findById(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    @Override
    public void delete() {

    }
}
