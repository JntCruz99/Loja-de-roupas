package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Categoria;
import com.example.Loja.de.roupas.Entity.Cliente;
import com.example.Loja.de.roupas.Service.CategoriaService;
import com.example.Loja.de.roupas.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> clienteList(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> clienteFindId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> clienteCreated(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }
}
