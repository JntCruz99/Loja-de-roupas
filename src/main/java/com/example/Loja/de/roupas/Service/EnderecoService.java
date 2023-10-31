package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco save(Endereco endereco);

    Endereco findById(Long id);

    List<Endereco> findAll();

    void delete(Endereco endereco);
}
