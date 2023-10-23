package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);

    Usuario findById(Long id);

    List<Usuario> findAll();

    void delete();
}
