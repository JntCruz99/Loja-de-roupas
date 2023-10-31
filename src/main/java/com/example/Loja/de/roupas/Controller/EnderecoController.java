package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Endereco;
import com.example.Loja.de.roupas.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController{

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.save(endereco);
    }

    @GetMapping("/{id}")
    public Endereco buscarEnderecoPorId(@PathVariable Long id) {
        return enderecoService.findById(id);
    }

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void excluirEndereco(@PathVariable Long id) {
        Endereco endereco = enderecoService.findById(id);
        enderecoService.delete(endereco);
    }
}
