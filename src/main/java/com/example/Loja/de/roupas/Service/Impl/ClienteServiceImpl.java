package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Cliente;
import com.example.Loja.de.roupas.Repository.ClienteRepository;
import com.example.Loja.de.roupas.Service.ClienteService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void delete() {

    }
}
