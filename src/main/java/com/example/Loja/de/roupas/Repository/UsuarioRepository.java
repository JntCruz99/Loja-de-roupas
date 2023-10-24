package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Carrinho;
import com.example.Loja.de.roupas.Entity.Usuario;
import com.example.Loja.de.roupas.Entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByNome(String nome);

    List<Usuario> findByCarrinhos_Status(Status status);

    Usuario findByLogin(String login);

    @Query("SELECT carrinho FROM Carrinho carrinho WHERE carrinho.usuario.id = :usuarioId AND carrinho.status = :status")
    List<Carrinho> findCarrinhosPendentesByClienteId(@Param("usuarioId") Long clienteId, @Param("status") Status status);


}
