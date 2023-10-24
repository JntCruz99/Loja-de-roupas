package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Usuario;
import com.example.Loja.de.roupas.Repository.UsuarioRepository;
import com.example.Loja.de.roupas.Service.UsuarioService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    @Override
    public void delete() {

    }
}
