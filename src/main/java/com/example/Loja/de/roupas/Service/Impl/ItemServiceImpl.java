package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Item;
import com.example.Loja.de.roupas.Repository.CarrinhoRepository;
import com.example.Loja.de.roupas.Repository.ItemRepository;
import com.example.Loja.de.roupas.Service.CarrinhoService;
import com.example.Loja.de.roupas.Service.ItemService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public void delete(Long id) {
        Item item = findById(id);
        Carrinho carrinho = itemRepository.findCarrinhoByItem(item).orElseThrow(
                () -> new EntityNotFoundExceptions("Item não encontrado: " + item.getProduto().getNome()));
        itemRepository.delete(item);
        List<Item> itemList =  carrinho.getItens();
        itemList.remove(item);
        carrinho.setItens(itemList);
        carrinho.setTotal(carrinho.getTotal());
        carrinhoRepository.save(carrinho);
    }
}
