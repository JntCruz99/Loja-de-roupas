package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i.carrinho FROM Item i WHERE i = :item")
    Optional<Carrinho> findCarrinhoByItem(@Param("item") Item item);
}
