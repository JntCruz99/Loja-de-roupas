package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Carrinho;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CarrinhoService {

    Carrinho save(Carrinho carrinho);

    Carrinho findById(Long id);

    List<Carrinho> findAll();

    List<Carrinho> findCarrinhosByUsuarioUsername(String username);

    Carrinho setCarrinhoUsuario(Authentication authentication, Long produtoId);

    void delete();
}
