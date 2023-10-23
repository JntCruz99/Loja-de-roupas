package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Usuario;
import com.example.Loja.de.roupas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> clienteList(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> clienteFindId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Usuario> clienteCreated(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }
}
