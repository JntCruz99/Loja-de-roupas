package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Categoria;
import com.example.Loja.de.roupas.Repository.CarrinhoRepository;
import com.example.Loja.de.roupas.Repository.CategoriaRepository;
import com.example.Loja.de.roupas.Service.CategoriaService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public Categoria save(Categoria categoria) {
        categoriaRepository.save(categoria);
        return categoria;
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public void delete() {

    }
}
