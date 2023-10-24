package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    List<Carrinho> findByStatus(Status status);
    @Query("SELECT c FROM Carrinho c WHERE c.usuario.login = :login")
    List<Carrinho> findByUsuarioUsername(@Param("login") String login);
}
