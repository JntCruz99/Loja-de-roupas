package com.example.Loja.de.roupas.Service;

import com.example.Loja.de.roupas.Entity.Categoria;
import com.example.Loja.de.roupas.Entity.Item;

public interface ItemService {
    Item save(Item item);

    Item findById(Long id);

    void delete(Long id);
}
