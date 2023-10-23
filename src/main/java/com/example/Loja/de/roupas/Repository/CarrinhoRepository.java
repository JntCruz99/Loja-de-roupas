package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    List<Carrinho> findByStatus(Status status);
}
