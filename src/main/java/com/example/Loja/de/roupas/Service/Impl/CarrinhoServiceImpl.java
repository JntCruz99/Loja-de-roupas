package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Item;
import com.example.Loja.de.roupas.Entity.Produto;
import com.example.Loja.de.roupas.Entity.Usuario;
import com.example.Loja.de.roupas.Entity.enums.Status;
import com.example.Loja.de.roupas.Repository.CarrinhoRepository;
import com.example.Loja.de.roupas.Repository.ItemRepository;
import com.example.Loja.de.roupas.Service.CarrinhoService;
import com.example.Loja.de.roupas.Service.ItemService;
import com.example.Loja.de.roupas.Service.ProdutoService;
import com.example.Loja.de.roupas.Service.UsuarioService;
import com.example.Loja.de.roupas.Service.exceptions.EntityNotFoundExceptions;
import com.example.Loja.de.roupas.Service.exceptions.NotAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.Loja.de.roupas.Entity.enums.Status.PENDENTE;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public Carrinho save(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
        return carrinho;
    }

    @Override
    public Carrinho findById(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Id Não encontrado: " + id));
    }

    @Override
    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    @Override
    public List<Carrinho> findCarrinhosByUsuarioUsername(String username) {
        return carrinhoRepository.findByUsuarioUsername(username);
    }

    @Override
    public Carrinho setCarrinhoUsuario(Authentication authentication, Long produtoId, int qtd) {
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Usuario usuario = usuarioService.findByLogin(username);
            Produto produto = produtoService.findById(produtoId);

            Carrinho carrinhoPendente = null;

            for (Carrinho c : usuario.getCarrinhos()) {
                if (c.getStatus().equals(Status.PENDENTE)) {
                    carrinhoPendente = c;
                    break;
                }
            }

            if (carrinhoPendente == null) {
                Carrinho newCarrinho = new Carrinho();
                Item newItem = new Item(qtd, produto, newCarrinho);
                newCarrinho.setStatus(Status.PENDENTE);
                newCarrinho.setItem(newItem);
                newCarrinho.setUsuario(usuario);
                newCarrinho.setTotal(newCarrinho.getTotal());
                usuario.setCarrinho(newCarrinho);

                carrinhoRepository.save(newCarrinho);
                itemService.save(newItem);
                usuarioService.save(usuario);
                return newCarrinho;
            } else {
                Item newItem = new Item(qtd, produto, carrinhoPendente);
                carrinhoPendente.setItem(newItem);
                carrinhoPendente.setUsuario(usuario);
                carrinhoPendente.setTotal(carrinhoPendente.getTotal());
                usuario.setCarrinho(carrinhoPendente);
                carrinhoRepository.save(carrinhoPendente);
                itemService.save(newItem);
                usuarioService.save(usuario);
                return carrinhoPendente;
            }
        }

        throw new NotAuthentication("Não autenticado" + authentication);
    }

    @Override
    public void removeItemCarrinho(Long itemId) {
        itemService.delete(itemId);
    }


    @Override
    public void delete() {

    }
}
