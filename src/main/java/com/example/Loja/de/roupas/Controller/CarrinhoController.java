package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<List<Carrinho>> carrinhoList(){
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> carrinhoFindId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Carrinho> carrinhoCreated(@RequestBody Carrinho carrinho){
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.save(carrinho));
    }
}
