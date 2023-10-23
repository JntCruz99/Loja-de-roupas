package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
