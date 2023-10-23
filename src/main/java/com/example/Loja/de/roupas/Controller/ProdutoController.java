package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Cliente;
import com.example.Loja.de.roupas.Entity.Produto;
import com.example.Loja.de.roupas.Service.ClienteService;
import com.example.Loja.de.roupas.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> produtoList(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> produtoFindId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Produto> produtoCreated(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }
}
