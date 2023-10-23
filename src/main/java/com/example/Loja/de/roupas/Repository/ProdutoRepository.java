package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
