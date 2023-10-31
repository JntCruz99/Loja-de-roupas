package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Endereco;
import com.example.Loja.de.roupas.Repository.EnderecoRepository;
import com.example.Loja.de.roupas.Service.EnderecoService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco save(Endereco endereco) {
        enderecoRepository.save(endereco);
        return endereco;
    }

    @Override
    public Endereco findById(Long id) {
        return enderecoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }


    @Override
    public void delete(Endereco endereco) {
        enderecoRepository.delete(endereco);
    }
}
