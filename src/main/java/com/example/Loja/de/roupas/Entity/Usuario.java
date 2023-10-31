package com.example.Loja.de.roupas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

    private String password;
    
    private String cpf;

    private String endereco;

    private String email;

    private boolean verificado;

    @OneToOne
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    @OneToMany(mappedBy = "usuario")
    private List<Carrinho> carrinhos;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setCarrinho(Carrinho carrinho){
        if (carrinhos == null) {
            carrinhos = new ArrayList<>();
        }
        carrinhos.add(carrinho);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleName().toString()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
