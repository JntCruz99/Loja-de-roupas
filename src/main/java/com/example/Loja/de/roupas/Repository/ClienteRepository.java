package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Cliente;
import com.example.Loja.de.roupas.Entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> findByNome(String nome);

    List<Cliente> findByCarrinhos_Status(Status status);

    @Query("SELECT carrinho FROM Carrinho carrinho WHERE carrinho.cliente.id = :clienteId AND carrinho.status = :status")
    List<Carrinho> findCarrinhosPendentesByClienteId(@Param("clienteId") Long clienteId, @Param("status") Status status);
}
