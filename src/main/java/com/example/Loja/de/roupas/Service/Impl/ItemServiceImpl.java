package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Item;
import com.example.Loja.de.roupas.Repository.ItemRepository;
import com.example.Loja.de.roupas.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
