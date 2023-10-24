package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Usuario;
import com.example.Loja.de.roupas.Service.CarrinhoService;
import com.example.Loja.de.roupas.Service.ProdutoService;
import com.example.Loja.de.roupas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;



    @GetMapping
    public ResponseEntity<List<Carrinho>> carrinhoList(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = authentication.getName();

        List<Carrinho> carrinhos = carrinhoService.findCarrinhosByUsuarioUsername(username);

        return ResponseEntity.status(HttpStatus.OK).body(carrinhos);
    }

    @PostMapping("/produto/{produtoId}/{quatidadePd}")
    public ResponseEntity<Carrinho> setCarrinhoUsuario(Authentication authentication, @PathVariable Long produtoId, @PathVariable int quatidadePd) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.setCarrinhoUsuario(authentication, produtoId, quatidadePd));
    }
}

