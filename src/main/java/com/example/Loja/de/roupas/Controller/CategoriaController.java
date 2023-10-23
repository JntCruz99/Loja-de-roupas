package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Categoria;
import com.example.Loja.de.roupas.Repository.CategoriaRepository;
import com.example.Loja.de.roupas.Service.CarrinhoService;
import com.example.Loja.de.roupas.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> categoriaList(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> categoriaFindId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Categoria> categoriaCreated(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }
}
