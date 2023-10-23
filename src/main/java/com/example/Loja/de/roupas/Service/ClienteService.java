package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Categoria;
import com.example.Loja.de.roupas.Entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente save(Cliente cliente);

    Cliente findById(Long id);

    List<Cliente> findAll();

    void delete();
}
