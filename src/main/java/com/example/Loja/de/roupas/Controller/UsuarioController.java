package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Entity.Role;
import com.example.Loja.de.roupas.Entity.Usuario;
import com.example.Loja.de.roupas.Entity.enums.RoleName;
import com.example.Loja.de.roupas.Repository.RoleRepository;
import com.example.Loja.de.roupas.Service.TokenService;
import com.example.Loja.de.roupas.Service.UsuarioService;
import com.example.Loja.de.roupas.dto.Login;
import com.example.Loja.de.roupas.dto.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(),
                        login.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();

        String token = tokenService.gerarToken(usuario);

        Long expiresIn = tokenService.getRemainingTokenExpiration(token);

        TokenResponse tokenResponse = new TokenResponse(token, expiresIn, usuario.isVerificado());

        return tokenResponse;
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario) {
        Role role = roleRepository.findByRoleName(RoleName.ROLE_USER);
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuario.setRole(role);
        usuarioService.save(usuario);
        return usuario;
    }

}
