package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
